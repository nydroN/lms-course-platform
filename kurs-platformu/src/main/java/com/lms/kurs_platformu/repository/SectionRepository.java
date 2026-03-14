package com.lms.kurs_platformu.repository;

import com.lms.kurs_platformu.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {

    // Kurs ID'sine göre o kursa ait tüm bölümleri listeleyen sihirli metod
    // Spring Boot bunu okuyunca "SELECT * FROM sections WHERE CourseId = ?" sorgusunu kendi yazar.
    List<Section> findByCourseId(Integer courseId);
}