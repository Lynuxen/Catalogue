package com.dbcs.homework9.controllers;

import com.dbcs.homework9.model.Course;
import com.dbcs.homework9.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("professor")
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping("courses")
    public List<Course> getAllCoursesByProf(@PathVariable Integer profId) {
        return professorService.getAllCoursesByProfId(profId);
    }
}
