package com.demo.spring.dao.impl;

import com.demo.spring.Dao;
import com.demo.spring.Employee;

public class OtherDaoImpl implements Dao {

	@Override
	public String saveEmp(Employee e) {
		return "Using Other Class --> Emp Saved";
	}
	
}