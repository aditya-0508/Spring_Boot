package com.springboot.cruddemo.service;

import com.springboot.cruddemo.DAO.EmployeeRepository;
import com.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){

        employeeRepository=theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee=null;
        if(result.isPresent())
            theEmployee=result.get();
        else
            throw new RuntimeException("Did not find employee id -"+theId);
        return theEmployee;
    }//these changes are needed as of new feature of java 8

    @Override
    public Employee save(Employee theEmployee) {

        return employeeRepository.save(theEmployee);
    }
    
    @Override
    public void deleteById(int theId) {

        employeeRepository.deleteById(theId);
    }
}
//in this employeeDAO part we have added the dependency injection part and
//refactor the restcontroller part so that service layer part can be added in with ease.

