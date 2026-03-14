package com.lms.kurs_platformu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lessons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Title", length = 250)
    private String title;

    @Column(name = "VideoUrl", length = 500)
    private String videoUrl;

    @Column(name = "Duration")
    private Integer duration;

    @Column(name = "SortOrder")
    private Integer sortOrder;

    @Column(name = "IsPreview")
    private Boolean isPreview;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SectionId")
    private Section section;
}