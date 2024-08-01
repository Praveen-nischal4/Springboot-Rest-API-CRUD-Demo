package com.coolwork.projects.service;

import java.util.List;

import com.coolwork.projects.entity.Employee;

public interface EmployeeService {

	List<Employee> finAll();
	
    public Employee findById(int id);
	
	public Employee Save(Employee emp);
	
	public void DeleteById(int id);
}
