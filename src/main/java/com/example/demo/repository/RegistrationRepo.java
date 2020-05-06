package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Registration;
import com.example.demo.model.LogedUserDetail;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration,Long> {

	
	// login  user deatils...........
  	@Query("select new com.example.demo.model.LogedUserDetail(s.id,s.firstName ,s.password ,s.emailId)from Registration s where firstName=?1 and password=?2")
	LogedUserDetail findUserbyNameandPass(String emailId,String password);
}
