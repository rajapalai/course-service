package com.namrata.ongraphy.javatechie.courseservice.controller;


import com.namrata.ongraphy.javatechie.courseservice.dto.Course;
import com.namrata.ongraphy.javatechie.courseservice.service.CourseService;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
//@RestController = @Controller and @ResponseBody
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //@RequestMapping(value = "/course",method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course){

        Course newCourse = courseService.onBoardNewCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);//201
    }

    @GetMapping
    public ResponseEntity<?> findAllCourse(){
        return new ResponseEntity<>(courseService,HttpStatus.OK);
    }

    @GetMapping("/search/path/{courseId}")
    public ResponseEntity<?> findCourse(@PathVariable Integer courseId){
        return new ResponseEntity<>(courseService.findByCourseId(courseId),HttpStatus.OK);

    }

    @GetMapping("/search/request")
    public ResponseEntity<?> findCourseUsingRequestParam(@RequestParam(required = false) Integer courseId){
        return new ResponseEntity<>(courseService.findByCourseId(courseId),HttpStatus.OK);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable int courseId){
               courseService.deleteCourse(courseId);
               return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<?> updateCourse(@PathVariable int courseId, @RequestBody Course course){
             return new ResponseEntity<>(courseService.updateCourse(courseId,course),HttpStatus.OK);
    }
}
