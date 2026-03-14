package com.lms.kurs_platformu.service;

import com.lms.kurs_platformu.dto.CourseResponseDto;
import com.lms.kurs_platformu.entity.Course;
import com.lms.kurs_platformu.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<CourseResponseDto> getAllCourses() {
        return courseRepository.findAll().stream().map(course -> new CourseResponseDto(
                course.getId(),
                course.getTitle(),
                course.getSubTitle(),
                course.getCategory() != null ? course.getCategory().getName() : "Kategorisiz",
                course.getDescription(),
                course.getPrice(),
                course.getPublishedAt()
        )).collect(Collectors.toList());
    }

    public CourseResponseDto getCourseById(Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kurs bulunamadı! ID: " + id));

        return new CourseResponseDto(
                course.getId(),
                course.getTitle(),
                course.getSubTitle(),
                course.getCategory() != null ? course.getCategory().getName() : "Genel",
                course.getDescription(),
                course.getPrice(),
                course.getPublishedAt()
        );
    }

    // YENİ: Controller'ın beklediği addCourse metodunu buraya ekledik
    public CourseResponseDto addCourse(Course course) {
        Course savedCourse = courseRepository.save(course);
        return new CourseResponseDto(
                savedCourse.getId(),
                savedCourse.getTitle(),
                savedCourse.getSubTitle(),
                savedCourse.getCategory() != null ? savedCourse.getCategory().getName() : "Kategorisiz",
                savedCourse.getDescription(),
                savedCourse.getPrice(),
                savedCourse.getPublishedAt()
        );
    }
    public void deleteCourse(Integer id) {
        // Önce kurs var mı diye kontrol edelim (Opsiyonel ama profesyoneldir)
        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("Silinmek istenen kurs bulunamadı! ID: " + id);
        }
        // Kursu veritabanından sil
        courseRepository.deleteById(id);
    }
}