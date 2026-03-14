package com.lms.kurs_platformu.service;

import com.lms.kurs_platformu.dto.UserResponseDto;
import com.lms.kurs_platformu.entity.User;
import com.lms.kurs_platformu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder; // YENİ EKLENDİ
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final com.lms.kurs_platformu.security.JwtService jwtService;

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(user -> new UserResponseDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        )).collect(Collectors.toList());
    }

    public UserResponseDto registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Hata: Bu e-posta adresi zaten sistemde kayıtlı!");
        }

        String sifrelenmisSifre = passwordEncoder.encode(user.getPasswordHash());
        user.setPasswordHash(sifrelenmisSifre);

        // --- İŞTE HAYAT KURTARAN O SATIRLAR ---
        // Eğer dışarıdan rol gelmemişse (null ise), zorla "USER" yapıyoruz!
        if (user.getRole() == null) {
            user.setRole("USER");
        }
        // -------------------------------------

        User savedUser = userRepository.save(user);

        return new UserResponseDto(
                savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail()
        );
    }

    public String login(com.lms.kurs_platformu.dto.LoginRequestDto loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user == null) {
            throw new RuntimeException("Hata: Bu e-posta ile kayıtlı kullanıcı bulunamadı!");
        }

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Hata: Şifre yanlış!");
        }

        // DEĞİŞEN KISIM: Artık token üretirken adamın ROLÜNÜ de gönderiyoruz!
        return jwtService.generateToken(user.getEmail(), user.getRole());
    }
}