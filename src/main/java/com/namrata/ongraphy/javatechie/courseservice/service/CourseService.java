package com.namrata.ongraphy.javatechie.courseservice.service;


import com.namrata.ongraphy.javatechie.courseservice.dto.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CourseService {

    private List<Course> courseDatabase = new ArrayList<>();

    //create course object in DB--post
    public Course onBoardNewCourse(Course course){
        course.setCourseId(new Random().nextInt(3756));
        courseDatabase.add(course);
         return course;
    }

    //load all the course from database---get
    public List<Course> viewAllCourse(){
        return courseDatabase;
    }
    //filter course bu courseId---get
    public Course findByCourseId(Integer courseId){
          return courseDatabase.stream().filter(course->course.getCourseId()==courseId).findFirst().orElse(null);
    }

    //delete course---delete
    public void deleteCourse(int courseId){
        Course course = findByCourseId(courseId);
         courseDatabase.remove(course);
    }

    //update the course--put or patch
    public Course updateCourse(int courseId,Course course){
        Course existingCourse = findByCourseId(courseId);
        courseDatabase.set(courseDatabase.indexOf(existingCourse),course);
        return course;

    }


}
