package com.atguigu.p2.service;

import com.atguigu.p2.bean.Customer;

public class CustomerList {
	private Customer[] customers;  //用来保存客户对象的数组
	private int total = 0 ;                //记录已保存客户对象的数量
    
	/**
	 * @Description用来初始化customers数组的构造器
	 * @param   totalCustomer：指定customers数组的最大空间
	 */
	public CustomerList(int totalCustomer) {
		  customers = new Customer[totalCustomer];
		
	}
	
	/**
	 * @Description 将指定客户添加到数组中
	 * @author 86173
	 * @param customer
	 * @return  true:添加成功  false:添加失败
	 */
	public boolean addCustomer(Customer customer) {
		if (total >= customers.length ) {
		   return false;
		}
		customers[total] = customer;
		total++;
		return true;
	}
	
	/**
	 * @Despription 修改指定位置的客戶信息
	 * @author 86173
	 * @param index
	 * @param cust
	 * @return  true:修改成功  false:修改失敗
	 */
	public boolean replaceCustomer(int index, Customer cust) {
		
		if (index < 0 || index >= total) {
			return false;
		}
		customers[index] = cust;
		return true;
	}
	
	/**
	 * @Descripytion 刪除指定位置客戶
	 * @author 86173
	 * @param index
	 * @return  true:刪除成功 false:刪除失敗
	 */
	public boolean deleteCustomer(int index) {
		if (index < 0 || index >= total) {
			return false;
		}
		for (int i = index; i < total -1  ; i++) {
			customers[i]  = customers[i+1];
			
		}
		 customers[total - 1] = null;
		 total--;
		 return true;
	}
	
	/**
	 * @Description 获取所有客戶信息
	 * @author 86173
	 * @return
	 */
	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[total];
		for (int i = 0; i < total ; i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
	
	/**
	 * Description 获取指定索引位置上的客户
	 * @author 86173
	 * @param index
	 * @return 若找到返回元素，没找到返回null
	 */
	public Customer getCustomer(int index) {
		if (index < 0  ||  index >= total) {
			return null;
		}
		return customers[index];
	}
	
	/**
	 * Description 获取客户数量
	 * @author 86173
	 * @return
	 */
	public int getTotal() {
		return total;
	}
	

}
