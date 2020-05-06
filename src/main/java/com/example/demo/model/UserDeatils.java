package com.example.demo.model;

public class UserDeatils {

	 private String firstName;
	    private String password;
	    
	    
		public UserDeatils() {
			super();
		}


		public UserDeatils(String firstName, String password) {
			super();
			this.firstName = firstName;
			this.password = password;
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
	     
	    
	    
	
}
