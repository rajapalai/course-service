package com.namrata.ongraphy.javatechie.courseservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponse<T>{

    private HttpStatus httpStatus;
    private T response;

}
