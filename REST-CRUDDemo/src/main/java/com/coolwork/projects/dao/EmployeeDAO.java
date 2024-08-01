package com.coolwork.projects.dao;

import java.util.List;

import com.coolwork.projects.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public Employee Save(Employee emp);
	
	public void DeleteById(int id);
}
