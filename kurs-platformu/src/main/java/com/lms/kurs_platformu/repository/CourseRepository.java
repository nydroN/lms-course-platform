package com.lms.kurs_platformu.repository;

import com.lms.kurs_platformu.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByCategoryId(Integer categoryId);
}