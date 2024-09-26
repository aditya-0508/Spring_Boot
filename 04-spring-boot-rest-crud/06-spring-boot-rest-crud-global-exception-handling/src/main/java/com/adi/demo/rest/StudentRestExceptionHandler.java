package com.adi.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//this is the global exception handling class
@ControllerAdvice
public class StudentRestExceptionHandler {

    //add exception handling code here

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        //create a StudentErrorResponse
        StudentErrorResponse error=new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMsg(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse error=new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMsg(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
