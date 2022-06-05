package com.scoremanagment.service;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scoremanagment.config.JwtTokenUtil;
import com.scoremanagment.entities.DAOUser;
import com.scoremanagment.repository.ScoreRepository;
import com.scoremanagment.repository.UserDao;

@Component

public class UserService {

	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ScoreRepository scoreRepository;
	
	// This function return User object from token
	public DAOUser getCurrentUser(HttpServletRequest request) {
		
		
		//get token from header
		final String requestTokenHeader = request.getHeader("Authorization");
		
		// eliminate "Bearer" from token string
		String jwtToken = requestTokenHeader.substring(7);
		
		String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
		
		DAOUser user = userDao.findByUsername(username);
		
		return user;
	}
	
	public void arrivageTimeFunction(String date,String arrivageTime , long userID){
		scoreRepository.arrivageTime(date,arrivageTime, userID);
		}
	public void sortiePointage(String tempSortie , long userID) {
		scoreRepository.offTime(tempSortie, userID);
	}
}
