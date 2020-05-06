package com.example.demo.model;

public class LogedUserDetail {
	
	 private long id;
	    private String firstName;
	    private String password;
	    private String emailId;
	    
	    
		public LogedUserDetail() {
			super();
		}


		public LogedUserDetail(long id, String firstName, String password, String emailId) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.password = password;
			this.emailId = emailId;
		}


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


	
	    

}
