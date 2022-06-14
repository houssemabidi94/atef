package com.scoremanagment.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scoremanagment.config.JwtTokenUtil;
import com.scoremanagment.entities.DAOUser;
import com.scoremanagment.entities.Score;
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
	public void sortiePointage(String tempSortie , long userID, String date) {
		scoreRepository.offTime(tempSortie, userID, date);
	}
	public String findDateByUser(long UserID) {
		return scoreRepository.findDateByUser(UserID);
	}
	public String calculHeure(long UserID,String date) {
		Score score = scoreRepository.findByUser(UserID,date);
		
		String heureEntree = score.getArrivalTime();
		String heureSortie = score.getKnockingofftime();
		
		int arriveeH = Integer.parseInt(heureEntree.substring(0,2));
		int arriveeM = Integer.parseInt(heureEntree.substring(3));
		
		int sortieH = Integer.parseInt(heureSortie.substring(0,2));
		int sortieM = Integer.parseInt(heureSortie.substring(3));
		
		int workHour = sortieH - arriveeH;
		int workMinute = sortieM-arriveeM;
		
		if(workMinute<0) {
			workHour --;
			workMinute = 59;
		}	
		String hour =String.valueOf(workHour)+ ":"+String.valueOf(workMinute);
		return hour;
	}
	
	public void setNbDaysOff(String nb,long userID) {
		scoreRepository.nbDaysOff(nb, userID);
	}
	
	public List<Score> getScoreByUser(long userID){
		List<Score> scores = scoreRepository.findByUserId(userID);
		return scores;
	}
}
