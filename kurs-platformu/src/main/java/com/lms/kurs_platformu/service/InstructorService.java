package com.lms.kurs_platformu.service;

import com.lms.kurs_platformu.entity.Instructor;
import com.lms.kurs_platformu.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;

    // 1. Sistemdeki tüm eğitmenleri listele
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    // 2. Yeni eğitmen ekle
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }
}