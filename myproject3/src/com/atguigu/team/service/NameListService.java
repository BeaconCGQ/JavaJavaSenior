package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Equipment;
import com.atguigu.team.domain.NoteBook;
import com.atguigu.team.domain.PC;
import com.atguigu.team.domain.Printer;
import com.atguigu.team.domain.Programmer;

/**
 *@Description  负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
 *@author 86173
 *@data2021年4月7日
 *
 */
public class NameListService {

	private Employee[] employees;
	
	public NameListService() {
		/**
		 * 给employees数组及数组元素初始化
		 */
//		1.根据项目提供的Data类构建相应大小的employees数组
//		2.再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
//		3.将对象存于数组中
		
		employees = new Employee[Data.EMPLOYEES.length];
		
	    for(int i = 0; i < employees.length; i++) {
	    	int type = Integer.parseInt(Data.EMPLOYEES[i][0]);	   
	    	
	    	//获取employee四个基本信息
	    	int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
	    	String name = Data.EMPLOYEES[i][2];
	    	int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
	    	double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
	    	
	    	Equipment equipment;
	    	double bonus;
	    	int stock;
	    	switch(type) {
	    	case Data.EMPLOYEE:
	    		employees[i] = new Employee(id, name, age, salary);
	    		break;
	    	case Data.PROGRAMMER:
	    		 equipment = creatEquipment(i);
	    		employees[i] = new Programmer(id, name, age, salary, equipment);
	    		break;
	    	case Data.DESIGNER:
	    		 equipment = creatEquipment(i);
	    		 bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
	    		 employees[i] = new Designer(id, name, age, salary, equipment, bonus);
	    		break;
	    	case Data.ARCHITECT:
	    		 equipment = creatEquipment(i);
	    		 bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
	    		 stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
	    		 employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
	    		break;
	    	}
	    }

	}
	/**
	 * @Desctiption 获取指定位置index上员工的设备
	 * @param i
	 */
	private Equipment creatEquipment(int index) {
	       
		int key = Integer.parseInt(Data.EQIPMENTS[index][0]);
		
		String modelOrName = Data.EQIPMENTS[index][1];
		switch(key) {
		case Data.PC://21
			String display =  Data.EQIPMENTS[index][2];
			return new PC(modelOrName,display);
			
		case Data.NOTEBOOK://22
			double price = Double.parseDouble(Data.EQIPMENTS[index][2]);
			return new NoteBook(modelOrName,price);
			
		case Data.PRINTER://23
			
			return new Printer(modelOrName,Data.EQIPMENTS[index][2]);
		}
		return null;
	}
/**
 * @Description 包含所有员工对象的数组

 * @return
 */
	public Employee[] getALLEmployees() {
		return employees;
	}
	/**
	 * @Description 获取指定ID的员工对象
	 * @param id
	 * @return
	 * @throws TeamException 
	 */
	public Employee getEmployee(int id) throws TeamException {
		
		for(int i = 0;i < employees.length; i++) {
			if(employees[i].getId() == id) {
				return employees[i];
			}
		}
		throw new TeamException("找不到指定的员工");
	}
}
