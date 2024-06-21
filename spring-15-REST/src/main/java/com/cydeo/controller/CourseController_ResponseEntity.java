package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2")
public class CourseController_ResponseEntity {

    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version","Cydeo_v2")
                .header("Operation", "Get Course List")
                .body(courseService.getCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") Long id){
        return ResponseEntity
                .ok(courseService.getCourseById(id));
    }

    @GetMapping("/category/{courseCategory}")
    public ResponseEntity<List<CourseDTO>> getCourseByCategory(@PathVariable("courseCategory") String category){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version","Cydeo_v2")
                .header("Operation", "Get Course By Category")
                .body(courseService.getCoursesByCategory(category));
    }

    @PostMapping()
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation","New Course Creation")
                .body(courseService.createCourse(courseDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable("id") Long id){
        courseService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable("id") Long id, @RequestBody CourseDTO courseDTO){
        courseService.updateCourse(id, courseDTO);
        return ResponseEntity.noContent().build();
    }


}
