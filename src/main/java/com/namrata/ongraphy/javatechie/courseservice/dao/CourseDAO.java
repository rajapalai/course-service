package com.namrata.ongraphy.javatechie.courseservice.dao;

import com.namrata.ongraphy.javatechie.courseservice.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO extends JpaRepository<CourseEntity,Integer> {
}
