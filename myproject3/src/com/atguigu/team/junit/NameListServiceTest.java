package com.atguigu.team.junit;

import org.junit.Test;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;

/**
 * @Description 测试NameListService类
 * @author 86173
 *2021年4月8日
 *
 */
public class NameListServiceTest {

	@Test
	public void testGetAllEmployees() {
		
		NameListService service = new NameListService();
		Employee[] employees = service.getALLEmployees();
		for(int i = 0; i < employees.length ; i++) {
			System.out.println(employees[i]);
		}
		
	}
	
	@Test
	public void testGetEmployee() {
		
		NameListService service = new NameListService();
		int id = 10;
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}
}
