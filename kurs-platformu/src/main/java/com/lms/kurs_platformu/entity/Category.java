package com.lms.kurs_platformu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "IsSubCategoryOf")
    private Integer isSubCategoryOf;

    @Column(name = "AddedAt")
    private LocalDate addedAt;

    @Column(name = "IsActive")
    private Boolean isActive;
}