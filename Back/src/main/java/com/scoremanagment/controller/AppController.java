package com.scoremanagment.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scoremanagment.config.JwtTokenUtil;
import com.scoremanagment.entities.DAOUser;
import com.scoremanagment.repository.UserDao;
import com.scoremanagment.service.UserService;

@RestController
public class AppController {

	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserService userService ;
	
	@GetMapping("/user")
	public DAOUser getUserFromToken(HttpServletRequest request) {
		
		//get token from header
		final String requestTokenHeader = request.getHeader("Authorization");
		
		// eliminate "Bearer" from token string
		String jwtToken = requestTokenHeader.substring(7);
		
		String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
		
		DAOUser user = userDao.findByUsername(username);
		
		return user;
		
	}
	
	@PutMapping("/pointageSortie")
	public void pointageSortie(HttpServletRequest request) {
		DAOUser user = userService.getCurrentUser(request);
		Date date = new Date();	
		SimpleDateFormat formatterTime= new SimpleDateFormat("HH:mm");
		try {
			userService.sortiePointage(formatterTime.format(date),user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
