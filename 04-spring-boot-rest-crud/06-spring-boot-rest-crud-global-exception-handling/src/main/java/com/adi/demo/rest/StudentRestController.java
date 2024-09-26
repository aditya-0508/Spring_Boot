package com.adi.demo.rest;

import com.adi.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    //define @PostConstruct to load the student data ... only once !!

    @PostConstruct
    public void loadData(){
        theStudents=new ArrayList<>();
        theStudents.add(new Student("Adi","Pandey"));
        theStudents.add(new Student("Perna","Rossi"));
    }

    //define endpoint for "/students" -return a list of

    @GetMapping("/students")
    public List<Student> getStudent(){

        return theStudents;
    }
    //define endpoint or "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){//here studentId is the path variable

        //just index into the list... keep it simple

        //check the studentId again list size
        if((studentId>=theStudents.size()|| (studentId<0)))
            throw new StudentNotFoundException("StudentId not found- "+studentId);
        return theStudents.get(studentId);//here studentId is used as the index
    }

}
//jackson is happening in the back to convert from pojo to json(here in this case)
//we are using the postconstruct to load the data only once and make it more efficient than before