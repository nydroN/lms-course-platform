package com.lms.kurs_platformu.service;

import com.lms.kurs_platformu.entity.Lesson;
import com.lms.kurs_platformu.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;

    public Lesson addLesson(Lesson lesson) {
        // İŞ KURALI: Ders önizleme mi değil mi backend karar verebilir
        if(lesson.getIsPreview() == null) lesson.setIsPreview(false);
        return lessonRepository.save(lesson);
    }
}