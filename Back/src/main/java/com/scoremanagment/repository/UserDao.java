package com.scoremanagment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.scoremanagment.entities.DAOUser;


/*
 * DELETE , CREATE => DELETE ON CASCADE
 */

@Transactional
public interface UserDao extends CrudRepository<DAOUser, Long> {
	
	DAOUser findByUsername(String username);
	
	@Query(value = "SELECT * from user", nativeQuery = true)
	List<DAOUser> findAllUsers();
	
	
	@Query(value = "SELECT * from user where id =:userid", nativeQuery = true)
	DAOUser findUserById(@Param("userid") long userId);
	
	
	

}