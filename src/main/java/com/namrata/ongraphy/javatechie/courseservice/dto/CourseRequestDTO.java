package com.namrata.ongraphy.javatechie.courseservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseRequestDTO {

    private String name;
    private String trainerName;
    private String duration; //days
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy")
    private Date startDate;
    private String courseType; //live or recording
    private double fees;
    private boolean isCertificateAvailable;
    private String description;
}
