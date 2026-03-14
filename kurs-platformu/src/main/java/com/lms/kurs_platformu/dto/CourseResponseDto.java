package com.lms.kurs_platformu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDto {
    private Integer id;
    private String title;
    private String subTitle;
    private String categoryName;
    // YENİ EKLENENLER:
    private String description;
    private BigDecimal price; // Double yerine BigDecimal yap (import java.math.BigDecimal; ekle)
    private LocalDate publishedAt;
}