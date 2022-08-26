package com.dbcs.homework9.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    String specialtyName;

    @OneToMany
    @NotNull
    List<Student> students = new ArrayList<>();

    @OneToMany
    @NotNull
    List<Course> courses = new ArrayList<>();
}
