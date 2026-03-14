package com.lms.kurs_platformu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courseinstructors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInstructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Hangi Kurs?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CourseId")
    private Course course;

    // Hangi Eğitmen?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "InstructorId")
    private Instructor instructor;
}