package com.dbcs.homework9.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    String subject;

    @NotNull
    Integer creditPoints;

    @ManyToOne
    Professor professor;

    @ManyToOne
    @NotNull
    Specialty specialty;
}
