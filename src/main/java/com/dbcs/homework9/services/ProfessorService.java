package com.dbcs.homework9.services;

import com.dbcs.homework9.model.Course;
import com.dbcs.homework9.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public List<Course> getAllCoursesByProfId(Integer profId) {
        return professorRepository
                .findById(profId)
                .orElseThrow()
                .getCourses();
    }
}
