package com.springboot.cruddemo.DAO;

import com.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.webmvc.RepositoryRestController;

//@RepositoryRestController(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer>//entity type and primary key
    {
        //that's it .. no need to write any code
}
