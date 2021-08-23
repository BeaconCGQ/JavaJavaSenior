package com.atguigu.p2.bean;


public class Customer {
     
	private String name;
	private char gender;
	private int age;          
	private String phone;
	private String email;
	
	
	
	public Customer() {
		
	}
	public Customer(String name, char gender, int age, String phone, String email) {
		
		this.name = name; //客户姓名
		this.gender = gender;  //  性别
		this.age = age;  //  年龄
		this.phone = phone;  // 电话号码
		this.email = email;   //电子邮箱
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
