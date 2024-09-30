package com.example.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix=theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theconstraintValidatorContext) {
        boolean result;
        if(theCode!=null)
            result=theCode.startsWith(coursePrefix);//validation logic--> test if the form data starts with our course prefix
        else
            result=true;

        return result;
    }
}
