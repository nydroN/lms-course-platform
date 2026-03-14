package com.lms.kurs_platformu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "instructors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {

    @Id
    @Column(name = "UserId")
    private Integer userId; // Hem Primary Key hem de User tablosuna giden Foreign Key

    @Column(name = "SubInfo", length = 100)
    private String subInfo;

    @Column(name = "Biography", length = 5000)
    private String biography;


    @OneToOne
    @MapsId
    @JoinColumn(name = "UserId")
    private User user;
}