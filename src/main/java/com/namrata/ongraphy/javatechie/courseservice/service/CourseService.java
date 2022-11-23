package com.namrata.ongraphy.javatechie.courseservice.service;

import com.namrata.ongraphy.javatechie.courseservice.dao.CourseDAO;
import com.namrata.ongraphy.javatechie.courseservice.dto.CourseRequestDTO;
import com.namrata.ongraphy.javatechie.courseservice.dto.CourseResponseDTO;
import com.namrata.ongraphy.javatechie.courseservice.entity.CourseEntity;
import com.namrata.ongraphy.javatechie.courseservice.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CourseService {
    @Autowired
    private CourseDAO courseDAO;

    // private List<Course> courseDatabase = new ArrayList<>();
    //we do not need ArrayList as we will use DB now

    //create course object in DB--post
    public CourseResponseDTO onBoardNewCourse(CourseRequestDTO courseRequestDTO){

        //Convert DTO to entity
        CourseEntity courseEntity = AppUtils.mapDTOToEntity(courseRequestDTO);
        CourseEntity save = courseDAO.save(courseEntity);
        //convert entity->response DTO
        CourseResponseDTO courseResponseDTO = AppUtils.mapEntityToDTO(save);
        courseResponseDTO.setCourseUniqueCode(UUID.randomUUID().toString().split("-")[0]);
        return courseResponseDTO;
    }

    //load all the course from database---get
    public List<CourseResponseDTO> viewAllCourse(){

        Iterable<CourseEntity> courseEntities = courseDAO.findAll();
        //lambda expression
        /*return StreamSupport.stream(courseEntities.spliterator(),false)
                .map(courseEntity -> AppUtils.mapEntityToDTO(courseEntity)).collect(Collectors.toList());*/
             //Method reference
        return StreamSupport.stream(courseEntities.spliterator(),false)
                .map(AppUtils::mapEntityToDTO).collect(Collectors.toList());

    }
    //filter course bu courseId---get
    public CourseResponseDTO findByCourseId(Integer courseId){
        CourseEntity courseEntity = courseDAO.findById(courseId)
                .orElseThrow(() -> new RuntimeException(courseId + "Not valid"));
        return AppUtils.mapEntityToDTO(courseEntity);
    }

    //delete course---delete
    public void deleteCourse(int courseId){
       courseDAO.deleteById(courseId);
    }

    //update the course--put or patch
    public CourseResponseDTO updateCourse(int courseId,CourseRequestDTO courseRequestDTO){

        //get the existing object
        CourseEntity existingCourseEntity = courseDAO.findById(courseId).orElse(null);
        //modify existing with new value then
        existingCourseEntity.setName(courseRequestDTO.getName());
        existingCourseEntity.setTrainerName(courseRequestDTO.getTrainerName());
        existingCourseEntity.setDuration(courseRequestDTO.getDuration());
        existingCourseEntity.setStartDate(courseRequestDTO.getStartDate());
        existingCourseEntity.setCourseType(courseRequestDTO.getCourseType());
        existingCourseEntity.setFees(courseRequestDTO.getFees());
        existingCourseEntity.setCertificateAvailable(courseRequestDTO.isCertificateAvailable());
        existingCourseEntity.setDescription(courseRequestDTO.getDescription());
           // save modified object
        CourseEntity updatedCourseEntity = courseDAO.save(existingCourseEntity);
        return AppUtils.mapEntityToDTO(updatedCourseEntity) ;

    }


}
