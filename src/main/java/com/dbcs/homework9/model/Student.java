package com.dbcs.homework9.model;

import com.dbcs.homework9.exceptions.NoGradeException;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    @OneToMany
    List<Grade> grades = new ArrayList<>();

    @NotNull
    @ManyToOne
    Specialty specialty;

    public int getAverageGrade() throws NoGradeException {
        if (grades.isEmpty()) {
            throw new NoGradeException();
        } else {
            return grades
                    .stream()
                    .mapToInt(Grade::getGrade)
                    .sum() /
                    grades.size();
        }
    }
}
