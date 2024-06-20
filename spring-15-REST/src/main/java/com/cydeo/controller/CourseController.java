package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long Id){
        return courseService.getCourseById(Id);
    }

    @GetMapping("/")
    public List<CourseDTO> getCourseByCategory(@RequestParam(value = "category", required = false) String category){
        return courseService.getCoursesByCategory(category);
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO){
        return courseService.createCourse(courseDTO);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") Long courseId, @RequestBody CourseDTO courseDTO){
        courseService.updateCourse(courseId,courseDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
    }



}
