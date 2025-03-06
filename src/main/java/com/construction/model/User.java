package com.construction.model;

import org.springframework.stereotype.Component;

@Component
public class User {

	private int u_id;
	private String fname;
	private String lname;
	private String uname;
	private String dob;
	private String gender;
	private String phoneno;
	private String email;
	private String password;

	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}

	

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
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

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
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

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", fname=" + fname + ", lname=" + lname + ", uname=" + uname + ", dob=" + dob
				+ ", gender=" + gender + ", phoneno=" + phoneno + ", email=" + email + ", password=" + password + "]";
	}

	public static User create(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public static User create(String fname, String lname, String uname, String dob, String gender, String phoneno, String email, String passoword) {
		User user = new User();
		user.setFname(fname);
		user.setLname(lname);
		user.setUname(uname);
		user.setDob(dob);
		user.setGender(gender);
		user.setPhoneno(phoneno);
		user.setEmail(email);
		user.setPassword(passoword);
		return user;
	}
	
}
