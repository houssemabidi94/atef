package com.scoremanagment.repository;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.scoremanagment.entities.DAOUser;
import com.scoremanagment.entities.Score;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "score", path = "score")
@Transactional
public interface ScoreRepository extends JpaRepository<Score, Long> {

	@Modifying
	@Query(value = "INSERT INTO score (date,arrival_time,code_emp) VALUES (:date,:arrivalTime , :userID) ", nativeQuery = true)
	public void arrivageTime(@Param("date") String date, @Param("arrivalTime") String arrivalTime,
			@Param("userID") long userID);

	@Modifying
	@Query(value = "UPDATE score SET knockingofftime =:offtime WHERE code_emp =:userID and date =:date", nativeQuery = true)
	public void offTime(@Param("offtime") String offTime, @Param("userID") long userID, @Param("date") String date);
	
	@Modifying
	@Query(value = "UPDATE user SET nb_heures =:nbHeures WHERE id =:userID", nativeQuery = true)
	public void calculTimeDB(@Param("nbHeures") String nbHeures, @Param("userID") long userID);
	
	
	@Modifying
	@Query(value = "UPDATE score SET nb_heures =:nbHeures WHERE code_emp =:userID and date =:date", nativeQuery = true)
	public void calculTimeDBScore(@Param("nbHeures") String nbHeures, @Param("userID") long userID, @Param("date") String date);
	
	@Modifying
	@Query(value = "UPDATE user SET nbdaysofdelay =:nb WHERE id =:userID", nativeQuery = true)
	public void nbDaysOff(@Param("nb") String nb, @Param("userID") long userID);
	
	@Query(value ="SELECT date from score WHERE code_emp =:userID", nativeQuery = true)
	public List<String> findDateByUser(@Param("userID") long userID);
	
	@Query(value ="SELECT * from score WHERE code_emp =:userID and date =:date", nativeQuery = true)
	public Score findByUser(@Param("userID") long userID, @Param("date") String date);
	
	@Query(value ="SELECT * from score  WHERE code_emp =:userID", nativeQuery = true)
	public List<Score> findByUserId(@Param("userID") long userID);
	
	
}
