package com.namrata.ongraphy.javatechie.courseservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.crypto.Data;

public class Course {

    private int courseId;
    private String name;
    private String trainerName;
    private String duration; //days
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy")
    private Data startDate;
    private String courseType; //live or recording
    private double fees;
    private boolean isCertificateAvailable;
    private String description;

    public Course() {
    }

    public Course(int courseId, String name, String trainerName, String duration,
                  Data startDate, String courseType, double fees, boolean isCertificateAvailable, String description) {
        this.courseId = courseId;
        this.name = name;
        this.trainerName = trainerName;
        this.duration = duration;
        this.startDate = startDate;
        this.courseType = courseType;
        this.fees = fees;
        this.isCertificateAvailable = isCertificateAvailable;
        this.description = description;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Data getStartDate() {
        return startDate;
    }

    public void setStartDate(Data startDate) {
        this.startDate = startDate;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public boolean isCertificateAvailable() {
        return isCertificateAvailable;
    }

    public void setCertificateAvailable(boolean certificateAvailable) {
        isCertificateAvailable = certificateAvailable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
