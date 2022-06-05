package com.scoremanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.scoremanagment.entities.DAOUser;
import com.scoremanagment.entities.Employee;


@CrossOrigin(origins="http://localhost:4200")
@RepositoryRestResource(collectionResourceRel="employee",path="employee")
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	Employee findByUsername(String username);

	

}
