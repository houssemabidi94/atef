package com.scoremanagment.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@DiscriminatorValue("Em")
public class Employee extends DAOUser{

	@ManyToOne
	@JoinColumn(name="code_emp_sup" )
	private DAOUser supemp;
	private String address;
	private double salary;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date endTime;
	
	private int daysoff;
	private int nbabsence;
	private int nbdaysofdelay;

	@OneToMany(mappedBy="emp",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	private Collection<Score> scores;

	public DAOUser getSupemp() {
		return supemp;
	}

	public void setSupemp(DAOUser supemp) {
		this.supemp = supemp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getDaysoff() {
		return daysoff;
	}

	public void setDaysoff(int daysoff) {
		this.daysoff = daysoff;
	}

	public int getNbabsence() {
		return nbabsence;
	}

	public void setNbabsence(int nbabsence) {
		this.nbabsence = nbabsence;
	}

	public int getNbdaysofdelay() {
		return nbdaysofdelay;
	}

	public void setNbdaysofdelay(int nbdaysofdelay) {
		this.nbdaysofdelay = nbdaysofdelay;
	}

	public Collection<Score> getScores() {
		return scores;
	}

	public void setScores(Collection<Score> scores) {
		this.scores = scores;
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	@ManyToOne
	@JoinColumn(name="code_dep")
	private Department dep;
	
	
}
