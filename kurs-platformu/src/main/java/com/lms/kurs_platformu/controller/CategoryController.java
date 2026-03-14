package com.lms.kurs_platformu.controller;

import com.lms.kurs_platformu.entity.Category;
import com.lms.kurs_platformu.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories") // Dışarıdan bu adrese gelecekler
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // GET: http://localhost:8080/api/categories (Kategorileri getir)
    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryService.getActiveCategories());
    }

    // POST: http://localhost:8080/api/categories/add (Yeni kategori ekle)
    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.addCategory(category));
    }
}