package com.lms.kurs_platformu.controller;

import com.lms.kurs_platformu.entity.Section;
import com.lms.kurs_platformu.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/sections")
@RequiredArgsConstructor
public class SectionController {
    private final SectionService sectionService;

    @PostMapping("/add")
    public ResponseEntity<Section> addSection(@RequestBody Section section) {
        return ResponseEntity.ok(sectionService.addSection(section));
    }
}