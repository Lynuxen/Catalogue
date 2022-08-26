package com.dbcs.homework9.repository;

import com.dbcs.homework9.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
