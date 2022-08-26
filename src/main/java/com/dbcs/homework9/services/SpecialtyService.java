package com.dbcs.homework9.services;

import com.dbcs.homework9.exceptions.NoGradeException;
import com.dbcs.homework9.model.Specialty;
import com.dbcs.homework9.model.Student;
import com.dbcs.homework9.repository.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public List<Student> getAllStudents(Integer specialtyId) {
        return specialtyRepository
                .findById(specialtyId)
                .orElseThrow()
                .getStudents();
    }

    public Specialty getSpecialtyWithMostStudents() {
        return specialtyRepository
                .findAll()
                .stream()
                .max(Comparator.comparing(length -> length.getStudents().size()))
                .orElseThrow();
    }

    public int getSpecialtyAverage(Integer specialtyId) {
        List<Student> studentsBySpecialty = specialtyRepository
                .findById(specialtyId)
                .orElseThrow()
                .getStudents();

        return studentsBySpecialty.stream().mapToInt(average -> {
            try {
                return average.getAverageGrade();
            } catch (NoGradeException e) {
                throw new RuntimeException(e);
            }
        }).sum() / studentsBySpecialty.size();
    }

//    who needs readability anyway
    public Student getStudentWithHighestGrade(Integer specialtyId) {
        return specialtyRepository
                .findById(specialtyId)
                .orElseThrow()
                .getStudents()
                .stream()
                .max(Comparator.comparing(average -> {
                    try {
                        return average.getAverageGrade();
                    } catch (NoGradeException e) {
                        throw new RuntimeException(e);
                    }
                }))
                .orElseThrow();
    }
}
