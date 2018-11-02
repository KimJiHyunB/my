package com.spring.exam2.vo;

public class User {
	
	String user_id;		
	String user_pass;	
	String user_name;	
	String user_email;	
	String user_phone;
	String user_add;
	int user_num;
	int user_cart;
	String user_authCode;
	int user_check;
	
	public User() {
	}
	
	

	public User(String user_id, String user_pass, String user_name, String user_email, String user_phone,
			String user_add, int user_num, int user_cart, String user_authCode, int user_check) {
		super();
		this.user_id = user_id;
		this.user_pass = user_pass;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.user_add = user_add;
		this.user_num = user_num;
		this.user_cart = user_cart;
		this.user_authCode = user_authCode;
		this.user_check = user_check;
	}



	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_add() {
		return user_add;
	}

	public void setUser_add(String user_add) {
		this.user_add = user_add;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	
	public int getUser_cart() {
		return user_cart;
	}

	public void setUser_cart(int user_cart) {
		this.user_cart = user_cart;
	}


	public String getUser_authCode() {
		return user_authCode;
	}


	public void setUser_authCode(String user_authCode) {
		this.user_authCode = user_authCode;
	}

	
	public int getUser_check() {
		return user_check;
	}



	public void setUser_check(int user_check) {
		this.user_check = user_check;
	}



	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_pass=" + user_pass + ", user_name=" + user_name + ", user_email="
				+ user_email + ", user_phone=" + user_phone + ", user_add=" + user_add + ", user_num=" + user_num
				+ ", user_cart=" + user_cart + ", user_authCode=" + user_authCode + ", user_check=" + user_check + "]";
	}
	

}
