package com.scoremanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.scoremanagment.entities.GRH;



@CrossOrigin(origins="http://localhost:4200")
@RepositoryRestResource(collectionResourceRel="grh",path="grh")
public interface grhRepository extends JpaRepository<GRH,Long> {
	
	

}
