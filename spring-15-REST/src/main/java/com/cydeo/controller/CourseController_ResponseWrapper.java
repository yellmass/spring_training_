package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v3")
public class CourseController_ResponseWrapper {
    private final CourseService courseService;

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourses(){
        ResponseWrapper wrapper = new ResponseWrapper("All courses list", courseService.getCourses());

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Version","Cydeo.V3")
                .body(wrapper);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id") Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Version","Cydeo.V3")
                .body(new ResponseWrapper("Course by id=" + id + " is retrieved",courseService.getCourseById(id)));
    }


}
