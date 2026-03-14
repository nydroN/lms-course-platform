package com.lms.kurs_platformu.service;

import com.lms.kurs_platformu.entity.Enrollment;
import com.lms.kurs_platformu.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public Enrollment enrollStudent(Enrollment enrollment) {
        // İŞ KURALI: Aynı kursa mükerrer kayıt engelleme
        if (enrollmentRepository.existsByUserIdAndCourseId(
                enrollment.getUser().getId(),
                enrollment.getCourse().getId())) {
            throw new RuntimeException("Hata: Bu kursa zaten kayıtlısınız!");
        }

        // Kayıt tarihini o anki zaman olarak ayarla
        enrollment.setEnrollmentDate(LocalDateTime.now());

        return enrollmentRepository.save(enrollment);
    }
}