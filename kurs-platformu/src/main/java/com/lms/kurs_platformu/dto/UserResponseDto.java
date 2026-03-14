package com.lms.kurs_platformu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    // Dikkat et, burada Password yok! Sadece dışarıya vermek istediğimiz temiz bilgiler var.
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}