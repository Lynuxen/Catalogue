package com.dbcs.homework9.controllers;

import com.dbcs.homework9.exceptions.StudentNotFoundException;
import com.dbcs.homework9.model.Grade;
import com.dbcs.homework9.model.Student;
import com.dbcs.homework9.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("getAllGrades/{studentId}")
    public List<Grade> getAllGrades(@PathVariable Integer studentId) throws StudentNotFoundException {
        return studentService.getAllGradesById(studentId);
    }

    @GetMapping("getAllStudents")
    public List<Student> getAllStudentsByAverage() {
        return studentService.getAllStudentsByAverage();
    }
}
