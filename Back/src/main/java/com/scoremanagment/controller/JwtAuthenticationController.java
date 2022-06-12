package com.scoremanagment.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scoremanagment.config.JwtTokenUtil;
import com.scoremanagment.entities.DAOUser;
import com.scoremanagment.entities.Employee;
import com.scoremanagment.entities.JwtRequest;
import com.scoremanagment.entities.JwtResponse;
import com.scoremanagment.repository.UserDao;
import com.scoremanagment.service.JwtUserDetailsService;
import com.scoremanagment.service.UserService;

@RestController
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		Date date = new Date();	
		SimpleDateFormat formatterDate= new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterTime= new SimpleDateFormat("HH:mm");
		String[] parts = formatterTime.format(date).split(":");
		
		String h = parts[0];
		String m = parts[1];

		String dateString = formatterDate.format(date);
		try {
			DAOUser currentUser = userDao.findByUsername(authenticationRequest.getUsername());
			if (Integer.parseInt(h)>=8 && Integer.parseInt(m)>30) {
				Employee employee = (Employee) currentUser;
				int nb = employee.getNbdaysofdelay();
				nb++;
				userService.setNbDaysOff(String.valueOf(nb), currentUser.getId());
			}
			if(userService.findDateByUser(currentUser.getId()) == null || !userService.findDateByUser(currentUser.getId()).equals(dateString))
				userService.arrivageTimeFunction(dateString,formatterTime.format(date) ,currentUser.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}


		return ResponseEntity.ok(new JwtResponse(token));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody Employee user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}