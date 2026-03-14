package com.lms.kurs_platformu.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
}