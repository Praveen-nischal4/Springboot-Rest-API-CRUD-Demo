package com.coolwork.projects.service;

import java.util.List;

import com.coolwork.projects.dao.EmployeeDAO;
import com.coolwork.projects.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO empDAO)
	{
		this.employeeDAO = empDAO;
	}

	@Override
	public List<Employee> finAll() {
	
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int id) {
		
		return employeeDAO.findById(id);
	}

	@Transactional 
	@Override
	public Employee Save(Employee emp) {
		
		return employeeDAO.Save(emp);
	}

	@Transactional
	@Override
	public void DeleteById(int id) {
		
		employeeDAO.DeleteById(id);
	}

}
