package com.dbcs.homework9.services;

import com.dbcs.homework9.model.Course;
import com.dbcs.homework9.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> getAllCoursesWithMoreThanThree() {
        return courseRepository
                .findAll()
                .stream()
                .filter(course -> course.getCreditPoints() > 3)
                .collect(Collectors.toList());
    }

    public List<Course> getAllWithMoreThanSelected(Integer creditPoints) {
        return courseRepository
                .findAll()
                .stream()
                .filter(course -> course.getCreditPoints() > creditPoints)
                .collect(Collectors.toList());
    }
}
