package com.scoremanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.scoremanagment.entities.Department;


@CrossOrigin(origins="http://localhost:4200")
@RepositoryRestResource(collectionResourceRel="dep",path="dep")
public interface DepartmentRepository extends JpaRepository<Department,Long> {
	
	

}

