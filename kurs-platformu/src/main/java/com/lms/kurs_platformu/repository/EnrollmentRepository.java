package com.lms.kurs_platformu.repository;

import com.lms.kurs_platformu.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    // Bu öğrenci bu kursa zaten kayıtlı mı?
    boolean existsByUserIdAndCourseId(Integer userId, Integer courseId);
}