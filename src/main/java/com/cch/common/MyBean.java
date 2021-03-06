package com.cch.common;

public class MyBean {

	private String name;
	private String password;
	private String introduce;

	public MyBean(String name, String password, String introduce) {
		super();
		this.name = name;
		this.password = password;
		this.introduce = introduce;
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

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@Override
	public String toString() {
		return "MyBean [name=" + name + ", password=" + password + ", introduce=" + introduce + "]";
	}

}
