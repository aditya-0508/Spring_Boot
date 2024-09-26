package com.adicode.cruddemo.dao;

import com.adicode.cruddemo.entity.Student;
import java.util.List;

public interface StudentDAO {

    void save (Student theStudent);

    Student findById(Integer id);//retrieving a java object with jpa

    List<Student> findAll();//querying

    List<Student> findByLastName(String theLastName);//for finding through last name

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
