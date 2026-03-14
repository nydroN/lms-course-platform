package com.lms.kurs_platformu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "categorywords")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LanguageId")
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryId")
    private Category category;

    @Column(name = "Word", length = 100)
    private String word;

    @Column(name = "AddedAt")
    private LocalDate addedAt;

    @Column(name = "IsActive")
    private Boolean isActive;
}