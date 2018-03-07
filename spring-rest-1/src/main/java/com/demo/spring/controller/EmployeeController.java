package com.demo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.dao.Dao;
import com.demo.spring.dao.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	Dao objEmp;
	
	@RequestMapping(path="/emp", method=RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Employee getEmployee(){
		Employee e =  objEmp.getEmployeeById(100);
		return e;
	}
	
	@RequestMapping(path="/emps", method=RequestMethod.POST, produces = {MediaType.TEXT_PLAIN_VALUE}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String saveEmpReturnString(@RequestParam("id") int id, @RequestParam("name")String name, @RequestParam("city")String city, @RequestParam("salary")double sal)
	{
		objEmp.save(new Employee(id,name,city,sal));
		return "success";
	}
	
	
	@RequestMapping(path="/empo", method=RequestMethod.POST, produces = {MediaType.APPLICATION_XML_VALUE}, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee saveEmpReturnObj(@RequestBody Employee e)
	{
		objEmp.save(e);
		Employee obj  =  objEmp.getEmployeeById(e.getEmpId());
		return obj;
	}
	
	//Not working Need to check this
	@RequestMapping(path="/allemp", method=RequestMethod.POST, produces = {MediaType.APPLICATION_XML_VALUE}, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> GetAllEmployeesReturnObj(@RequestBody Employee e)
	{
		objEmp.save(e);
		List<Employee> obj =  objEmp.listAllEmployee();
		return obj;
	}
}
