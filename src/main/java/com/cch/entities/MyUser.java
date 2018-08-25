package com.cch.entities;

public class MyUser {
	private String name;
	private String password;
	private String phone;
	private int sex;
	
	
	public MyUser() {
		super();
	}

	public MyUser(String name, String password, String phone, int sex) {
		super();
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.sex = sex;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "MyUser [name=" + name + ", password=" + password + ", phone=" + phone + ", sex=" + sex + "]";
	}
	
	

}
