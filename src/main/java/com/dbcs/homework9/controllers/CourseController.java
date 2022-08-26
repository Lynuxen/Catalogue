package com.dbcs.homework9.controllers;

import com.dbcs.homework9.model.Course;
import com.dbcs.homework9.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("all/greaterThanThree")
    public List<Course> getAllCoursesGreaterThanThree() {
        return courseService.getAllCoursesWithMoreThanThree();
    }

    @GetMapping("all/greaterThan/{credits}")
    public List<Course> getAllCoursesGreaterThanSelected(@PathVariable Integer credits) {
        return courseService.getAllWithMoreThanSelected(credits);
    }
}
