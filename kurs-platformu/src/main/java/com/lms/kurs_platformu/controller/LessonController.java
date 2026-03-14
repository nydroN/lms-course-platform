package com.lms.kurs_platformu.controller;

import com.lms.kurs_platformu.entity.Lesson;
import com.lms.kurs_platformu.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @PostMapping("/add")
    public ResponseEntity<Lesson> addLesson(@RequestBody Lesson lesson) {
        return ResponseEntity.ok(lessonService.addLesson(lesson));
    }
}