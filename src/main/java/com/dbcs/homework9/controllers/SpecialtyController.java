package com.dbcs.homework9.controllers;

import com.dbcs.homework9.model.Specialty;
import com.dbcs.homework9.model.Student;
import com.dbcs.homework9.services.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("specialty")
public class SpecialtyController {
    private final SpecialtyService specialtyService;

    @GetMapping("allStudents/{specialtyId}")
    public List<Student> getAllStudentsBySpecialty(@PathVariable Integer specialtyId) {
        return specialtyService.getAllStudents(specialtyId);
    }

    @GetMapping("mostStudents")
    public Specialty getSpecialtyWithMostStudents() {
        return specialtyService.getSpecialtyWithMostStudents();
    }

    @GetMapping("averageGrade/{specialtyId}")
    public Integer getAverageGradeOfSpecialty(@PathVariable Integer specialtyId) {
        return specialtyService.getSpecialtyAverage(specialtyId);
    }

    @GetMapping("highestGradedStudent/{specialtyId}")
    public Student getHighestGradedStudent(@PathVariable Integer specialtyId) {
        return specialtyService.getStudentWithHighestGrade(specialtyId);
    }
}
