package com.namrata.ongraphy.javatechie.courseservice.util;

import com.namrata.ongraphy.javatechie.courseservice.dto.CourseRequestDTO;
import com.namrata.ongraphy.javatechie.courseservice.dto.CourseResponseDTO;
import com.namrata.ongraphy.javatechie.courseservice.entity.CourseEntity;

public class AppUtils {

    //DTO->ENTITY

    public static CourseEntity mapDTOToEntity(CourseRequestDTO courseRequestDTO){
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(courseRequestDTO.getName());
        courseEntity.setTrainerName(courseRequestDTO.getTrainerName());
        courseEntity.setDuration(courseRequestDTO.getDuration());
        courseEntity.setStartDate(courseRequestDTO.getStartDate());
        courseEntity.setCourseType(courseRequestDTO.getCourseType());
        courseEntity.setFees(courseRequestDTO.getFees());
        courseEntity.setCertificateAvailable(courseRequestDTO.isCertificateAvailable());
        courseEntity.setDescription(courseRequestDTO.getDescription());
        return courseEntity;

    }
    public  static CourseResponseDTO mapEntityToDTO(CourseEntity courseEntity){
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setCourseId(courseEntity.getCourseId());
        courseResponseDTO.setName(courseEntity.getName());
        courseResponseDTO.setTrainerName(courseEntity.getTrainerName());
        courseResponseDTO.setDuration(courseEntity.getDuration());
        courseResponseDTO.setStartDate(courseEntity.getStartDate());
        courseResponseDTO.setCourseType(courseEntity.getCourseType());
        courseResponseDTO.setFees(courseEntity.getFees());
        courseResponseDTO.setCertificateAvailable(courseEntity.isCertificateAvailable());
        courseResponseDTO.setDescription(courseEntity.getDescription());
        return courseResponseDTO;


    }
}
