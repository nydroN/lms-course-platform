package com.lms.kurs_platformu.service;

import com.lms.kurs_platformu.entity.Section;
import com.lms.kurs_platformu.repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionService {
    private final SectionRepository sectionRepository;

    // Belirli bir kursun bölümlerini getir
    public List<Section> getSectionsByCourseId(Integer courseId) {
        return sectionRepository.findByCourseId(courseId); // Artık filtreliyoruz!
    }

    public Section addSection(Section section) {
        return sectionRepository.save(section);
    }
}