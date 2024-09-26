package com.example.thymeleaf.contoller;

import com.example.thymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")//making reference to countries in application.properties,injecting countries in controller
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        //create a student object
        Student theStudent=new Student();

        //add student object to the model
        theModel.addAttribute("student",theStudent);

        //add the list of countries to the model
        theModel.addAttribute("countries",countries);

        //add the list of languages to the model
        theModel.addAttribute("languages",languages);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        System.out.println("theStudent: "+theStudent.getFirstName()+" "+theStudent.getLastName());
        return "student-confirmation";
    }
}
