package com.springboot.cruddemo.Rest;

import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    //quick and dirty:inject employee dao(use constructor injection)
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){

        employeeService=theEmployeeService;
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){

        return employeeService.findAll();
    }

    //add mapping for GET /employees/{employeeId}
    //to get single employee from the list
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee=employeeService.findById(employeeId);
        if(theEmployee==null)
            throw  new RuntimeException("Employee id not found- "+employeeId);
        return theEmployee;
    }

    //when we doing with post in postman we will add in json in the body
    // add mapping for POST /employee -add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //also in case they pass id in json ...set that id to 0
        //this is to force a save of new item ...instead of update

        theEmployee.setId(0);
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }

    //add mapping for PUT /employees -update existing employees

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }

    // add mapping for DELETE /employees/{employeeId} -delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee delEmployee=employeeService.findById(employeeId);

        //throw exception if found null
        if(delEmployee==null)
            throw new RuntimeException("Employee id not found- "+employeeId);
        employeeService.deleteById(employeeId);
        return "Deleted employee id- "+employeeId;
    }
}
