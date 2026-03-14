package com.lms.kurs_platformu.service;

import com.lms.kurs_platformu.entity.Category;
import com.lms.kurs_platformu.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // 1. Sadece aktif olan kategorileri listele (Silinmişleri arayüze gönderme)
    public List<Category> getActiveCategories() {
        return categoryRepository.findByIsActiveTrue();
    }

    // 2. Yeni kategori ekle
    public Category addCategory(Category category) {
        // İŞ KURALI (BEYİN): Kullanıcı arayüzden tarih veya aktiflik durumu göndermesin.
        // Biz burada arka planda eklenme tarihini otomatik 'bugün' yapıyoruz ve aktif olarak işaretliyoruz.
        category.setAddedAt(LocalDate.now());
        category.setIsActive(true);

        return categoryRepository.save(category);
    }
}