package com.scoremanagment.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String date;
	
	private String arrivalTime;

	private String knockingofftime;
	
	private String nbHeures;

	@ManyToOne
	@JoinColumn(name = "code_emp")
	private Employee emp;

}
