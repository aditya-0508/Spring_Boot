package com.springboot.cruddemo.DAO;

import com.springboot.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
