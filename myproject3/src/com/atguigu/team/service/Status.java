package com.atguigu.team.service;
/**
 *@Description 表示员工状态 
 *@author 86173
 *@data 2021年4月7日
 *
 */
//public class Status {

//	private final String NAME;
//	private Status(String name){
//		this.NAME = name;
//	}
//
//	public static final Status FREE = new Status("FREE");
//	public static final Status BUSY = new Status("BUSY");
//	public static final Status VOCATION = new Status("VOCATION");
//
//
//
//	public String getNAME() {
//		return NAME;
//	}
//
//
//
//	@Override
//		public String toString() {
//
//			return NAME;
//		}
//}

public enum Status{
	FREE,BUSY,VOCATION;
}

