package com.dbcs.homework9.repository;

import com.dbcs.homework9.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
