package com.scoremanagment.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scoremanagment.config.JwtTokenUtil;
import com.scoremanagment.entities.DAOUser;
import com.scoremanagment.entities.Score;
import com.scoremanagment.repository.EmployeeRepository;
import com.scoremanagment.repository.ScoreRepository;
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
	
	@Autowired
	ScoreRepository scoreRepository;
	
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
		int heureT;
		int minT;
		DAOUser user = userService.getCurrentUser(request);
		Date date = new Date();	
		SimpleDateFormat formatterDate= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterTime= new SimpleDateFormat("HH:mm");
		userService.sortiePointage(formatterTime.format(date),user.getId(),formatterDate.format(date));
		String hours = userService.calculHeure(user.getId(),formatterDate.format(date));
	
		String[] parts = hours.split(":");
		
		String h = parts[0];
		String m = parts[1];
		
		System.out.println(hours + " --> hours = " + h + "  minutes = " + m);
		
		//NbHeures from db
		if(user.getNbHeures() !=null) {
		String hUser = user.getNbHeures();
		String[] parts2 = hUser.split(":");
		
		String h1 = parts2[0];
		String m1 = parts2[1];
		heureT = Integer.parseInt(h) + Integer.parseInt(h1);
	    minT = Integer.parseInt(m) + Integer.parseInt(m1);
	    if(minT >=60) {
	    	heureT ++;
	    	minT -= 60;
	    }
		}
		else {
			heureT = Integer.parseInt(h);
		    minT = Integer.parseInt(m);
		}

		String timeString = heureT + ":" + minT ;
		try {
			userService.calculHeure(user.getId(),formatterDate.format(date));
			scoreRepository.calculTimeDB(timeString, user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/users/{userId}")
	public DAOUser getUserById(@PathVariable("userId") long userId) {

		return userDao.findUserById(userId);
	}
	@GetMapping("/allusers")
	public List<DAOUser> getUsers() {

		return userDao.findAllUsers();
	}
	
	@GetMapping("/scores")
	public List<Score> getScoresByUser(HttpServletRequest request){
		DAOUser user = userService.getCurrentUser(request);
		return userService.getScoreByUser(user.getId());
	}
	
	@GetMapping("/scores/{id}")
	public List<Score> getScoresByUserID(@PathVariable("id") long id){
		return userService.getScoreByUser(id);
	}
} 
