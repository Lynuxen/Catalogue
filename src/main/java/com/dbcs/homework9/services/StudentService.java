package com.dbcs.homework9.services;

import com.dbcs.homework9.exceptions.NoGradeException;
import com.dbcs.homework9.exceptions.StudentNotFoundException;
import com.dbcs.homework9.model.Grade;
import com.dbcs.homework9.model.Student;
import com.dbcs.homework9.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Grade> getAllGradesById(Integer studentId) throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isEmpty()) {
            throw new StudentNotFoundException("Student with id: [" + studentId + "] not found");
        }
        return student.get().getGrades();
    }

    public List<Student> getAllStudentsByAverage() {
        return studentRepository.findAll().stream().filter(student -> {
            try {
                return student.getAverageGrade() > 8;
            } catch (NoGradeException e) {
                throw new RuntimeException();
            }
        }).collect(Collectors.toList());
    }
}
