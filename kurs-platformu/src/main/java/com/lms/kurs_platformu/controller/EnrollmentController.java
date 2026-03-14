package com.lms.kurs_platformu.controller;

import com.lms.kurs_platformu.entity.Enrollment;
import com.lms.kurs_platformu.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping("/enroll")
    public ResponseEntity<?> enrollStudent(@RequestBody Enrollment enrollment) {
        try {
            return ResponseEntity.ok(enrollmentService.enrollStudent(enrollment));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}