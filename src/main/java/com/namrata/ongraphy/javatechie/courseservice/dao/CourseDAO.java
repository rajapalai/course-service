package com.namrata.ongraphy.javatechie.courseservice.dao;

import com.namrata.ongraphy.javatechie.courseservice.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;

public interface CourseDAO extends CrudRepository<CourseEntity,Integer> {
}
