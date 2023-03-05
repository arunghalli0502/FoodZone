package com.foodzone;



public class User
{
	

	
	
	private String fname;
	private String lname;
	private String email;
	private String password;
	private long mobile_number;
	
	
	
	
	
	public User()
	{
		System.out.println("User calss excuting...");
	}
		
	

	public User(String fname, String lname, String email, String password, long mobile_number) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.mobile_number = mobile_number;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	
}
