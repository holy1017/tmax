package com;

import java.util.Calendar;

public class StudentBean { 
	private String id;		
	private String name;	
	private String snum;	
	private String birth;	
	private String pass;	
	private String email;	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSnum() {
		return snum;
	}
	
	public void setSnum(String snum) {
		this.snum = snum;
	}
	
	public String getBirth() {
		return birth.substring(0,4);
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}	
	public int getAge() {
		int curyear = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(curyear);
		return curyear - Integer.parseInt(birth.substring(0,4)) + 1;
	}

}