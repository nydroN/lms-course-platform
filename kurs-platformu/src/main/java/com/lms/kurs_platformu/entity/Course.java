package com.lms.kurs_platformu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Title", length = 500)
    private String title;

    @Column(name = "SubTitle", length = 500)
    private String subTitle;

    @Column(name = "Description", length = 5000)
    private String description;


    @Column(name = "Price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "PublishedAt")
    private LocalDate publishedAt;

    @Column(name = "UpdatedAt")
    private LocalDate updatedAt;


    @Column(name = "LanguageId")
    private Integer languageId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryId")
    private Category category;
}