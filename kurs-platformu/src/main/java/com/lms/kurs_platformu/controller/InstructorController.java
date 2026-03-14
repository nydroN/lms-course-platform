package com.lms.kurs_platformu.controller;

import com.lms.kurs_platformu.entity.Instructor;
import com.lms.kurs_platformu.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    // GET: http://localhost:8080/api/instructors
    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        return ResponseEntity.ok(instructorService.getAllInstructors());
    }

    // POST: http://localhost:8080/api/instructors/add
    @PostMapping("/add")
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor) {
        return ResponseEntity.ok(instructorService.addInstructor(instructor));
    }
}