package com.scoremanagment.repository;

import java.util.Date;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scoremanagment.entities.DAOUser;


/*
 * DELETE , CREATE => DELETE ON CASCADE
 */
@Repository
public interface UserDao extends CrudRepository<DAOUser, Long> {
	DAOUser findByUsername(String username);
	

}