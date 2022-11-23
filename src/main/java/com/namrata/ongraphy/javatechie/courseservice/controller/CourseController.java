package com.namrata.ongraphy.javatechie.courseservice.controller;


import com.namrata.ongraphy.javatechie.courseservice.dto.CourseRequestDTO;
import com.namrata.ongraphy.javatechie.courseservice.dto.CourseResponseDTO;
import com.namrata.ongraphy.javatechie.courseservice.dto.ServiceResponse;
import com.namrata.ongraphy.javatechie.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
//@RestController = @Controller and @ResponseBody
public class CourseController {

    @Autowired
    private CourseService courseService;


    //@RequestMapping(value = "/course",method = RequestMethod.POST)
    @PostMapping
    public ServiceResponse<CourseResponseDTO> addCourse(@RequestBody CourseRequestDTO courseRequestDTO){
        CourseResponseDTO newCourse = courseService.onBoardNewCourse(courseRequestDTO);
        return new ServiceResponse<>(HttpStatus.CREATED,newCourse);
    }

    @GetMapping
    public ServiceResponse<List<CourseResponseDTO>> findAllCourse(){
        List<CourseResponseDTO> courseResponseDTOS = courseService.viewAllCourse();
        return new ServiceResponse<>(HttpStatus.OK,courseResponseDTOS);
    }

    @GetMapping("/search/path/{courseId}")
    public ServiceResponse<CourseResponseDTO> findCourse(@PathVariable Integer courseId){
        CourseResponseDTO responseDTO = courseService.findByCourseId(courseId);
        return new ServiceResponse<>(HttpStatus.OK,responseDTO);

    }

    @GetMapping("/search/request")
    public ServiceResponse<CourseResponseDTO> findCourseUsingRequestParam(@RequestParam(required = false,defaultValue = "1") Integer courseId){
        CourseResponseDTO responseDTO = courseService.findByCourseId(courseId);
        return new ServiceResponse<>(HttpStatus.OK,responseDTO);    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable int courseId){
               courseService.deleteCourse(courseId);
               return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{courseId}")
    public ServiceResponse<CourseResponseDTO> updateCourse(@PathVariable int courseId, @RequestBody CourseRequestDTO courseRequestDTO){

        CourseResponseDTO courseResponseDTO = courseService.updateCourse(courseId, courseRequestDTO);
        return new ServiceResponse<>(HttpStatus.OK,courseResponseDTO);
    }
}
