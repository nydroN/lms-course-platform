package com.lms.kurs_platformu.repository;

import com.lms.kurs_platformu.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    // Bölüm ID'sine göre o bölüme ait tüm dersleri getiren metod
    List<Lesson> findBySectionId(Integer sectionId);

    // İstersen "Önizlemeye açık olan dersleri getir" gibi ekstra özellikler de ekleyebiliriz:
    List<Lesson> findBySectionIdAndIsPreviewTrue(Integer sectionId);
}