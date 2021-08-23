package com.atguigu.team.service;

/**
 * @Description 自定义异常类
 * @author 86173
 *2021年4月8日
 *
 */
public class TeamException extends Exception{

	static final long serialVersionUID = -3387516993124276948L;
	
	public TeamException() {
		
	}
	public TeamException(String msg) {
		super(msg);
	}
}
