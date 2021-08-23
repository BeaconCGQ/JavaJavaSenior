package com.atguigu.team.domain;

import com.atguigu.team.service.Status;

public class Programmer extends Employee{

	private int numberId;//开发团队id
	private Status status  = Status.FREE;
	private Equipment equipment;
	
	
	public Programmer() {
		super();
	}



	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}



	public int getNumberId() {
		return numberId;
	}



	public void setNumberId(int numberId) {
		this.numberId = numberId;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	public Equipment getEquipment() {
		return equipment;
	}



	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
 
    

	@Override
	public String toString() {
		
		return getDetails() +  "\t程序员\t" + status + "\t\t\t" + equipment.getDescription();
	}
	
	public String getTeamBaseDetails() {
		return numberId + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary();
	}
	
	public String getDetailsTeam() {
		return getTeamBaseDetails() + "\t程序员";
	}
}
