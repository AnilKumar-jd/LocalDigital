package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class Registration {

	    private long id;
	    private String firstName;
	    private String password;
	    private String emailId;

	    public Registration() {
			
		}

		public Registration(long id, String firstName, String password, String emailId) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.password = password;
			this.emailId = emailId;
		}

		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
	   
	    
		//@Id
	  //  @GeneratedValue(strategy = GenerationType.AUTO)
	   
	    
	}
