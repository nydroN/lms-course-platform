package com.lms.kurs_platformu.controller;

import com.lms.kurs_platformu.dto.CourseResponseDto;
import com.lms.kurs_platformu.entity.Course;
import com.lms.kurs_platformu.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')") // Sadece Adminler girebilir!
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseResponseDto>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping("/add")
    public ResponseEntity<CourseResponseDto> addCourse(@RequestBody Course course) {
        // Artık service tarafında bu metot var ve 7 alanlı DTO dönüyor
        return ResponseEntity.ok(courseService.addCourse(course));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Integer id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Kurs başarıyla silindi.");
    }
}