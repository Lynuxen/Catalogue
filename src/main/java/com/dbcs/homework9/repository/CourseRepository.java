package com.dbcs.homework9.repository;

import com.dbcs.homework9.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
