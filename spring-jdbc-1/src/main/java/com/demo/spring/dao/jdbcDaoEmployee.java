package com.demo.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

@Repository
public class jdbcDaoEmployee implements Dao {

	@Autowired
	JdbcTemplate jt;
	
	
	
	@Override
	public String save(Employee e) {
		// TODO Auto-generated method stub
		int row = jt.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement("insert into emp values(?,?,?,?)");
				pst.setInt(1, e.getEmpId());
				pst.setString(2, e.getName());
				pst.setString(3, e.getCity());
				pst.setDouble(4, e.getSalary());
				return pst;
			}
		});
		if (row == 0)
			return "Some unknow Exception";
		return "Employee " + e.getEmpId() + " Added into the Data Base";
	}

	@Override
	public String deleteEmp(int empId) {
		int row = jt.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement("delete from emp where empid = ?");
				pst.setInt(1, empId);
				/*pst.setString(2, e.getName());
				pst.setString(3, e.getCity());
				pst.setDouble(4, e.getSalary());*/
				return pst;
			}
		});
		if (row == 0)
			return "Some unknow Exception";
		return "Employee " + empId + " Deleted from DataBase";
	}

	@Override
	public List<Employee> listAllEmployee() {
		/*int row = jt.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement("select * from emp");
				pst.setInt(1, empId);
				pst.setString(2, e.getName());
				pst.setString(3, e.getCity());
				pst.setDouble(4, e.getSalary());
				return pst;
			}
		});
		if (row == 0)
			return "Some unknow Exception";
		return "Employee " + empId + " Deleted from DataBase";*/
		return null;
	}

	@Override
	public Employee getEmployeeById(int empid) {
		// TODO Auto-generated method stub
		return null;
	}

}