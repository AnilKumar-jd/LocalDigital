package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Registration;
import com.example.demo.repository.RegistrationRepo;

@Service
public class DigitalService {
	
	@Autowired
	RegistrationRepo regRepo;
	
	
	// to access dummy fetch all user with session management......
	
	 public List < Registration > getAllUser(HttpServletRequest request) {
		     HttpSession session = request.getSession();
			String userName=(String) session.getAttribute("userName");
              System.out.println("***********************************"+userName);
				if(userName !=null)
				{
					return regRepo.findAll();
			}
			else
			{
				return new ArrayList<Registration>();
			}
	    }


}
