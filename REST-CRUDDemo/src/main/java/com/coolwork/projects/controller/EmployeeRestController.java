package com.coolwork.projects.controller;

import java.util.List;


import com.coolwork.projects.entity.Employee;
import com.coolwork.projects.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService empService;
	
	@Autowired
	public EmployeeRestController(EmployeeService myempService)                //bean using constructor injection we can also use autowiring simple
	{
		this.empService = myempService;
	}
	
	
	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		return empService.finAll();
	}
	
	@GetMapping("/employees/{empId}")
	public Employee getEmployeeById(@PathVariable("empId") int id)
	{
		Employee myEmp = empService.findById(id);
		
		if(myEmp == null)
		{
			throw new RuntimeException("Employee Id not found");
		}
		
		return myEmp;
	}
	
	
	//code to add employe data
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee)
	{
		//also just in case they pass an id in json ... set it to 0
		//this is to force a save of new item ...  instead of update
		
		theEmployee.setId(0);
		
		Employee dbEmployee = empService.Save(theEmployee);
		
		return dbEmployee;
	}
	
	
	//code for update
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee myEmployee)
	{
		Employee dbEmp = empService.Save(myEmployee);
		return dbEmp;
		
	}
	
	
	//code for delete
	
	@DeleteMapping("/employees/{empId}")
	public String deleteEmployee(@PathVariable("empId") int id)
	{
		Employee emp = empService.findById(id);
		
		if(emp ==null)
		{
			throw new RuntimeException("Id not found "+id);
		}
		
		empService.DeleteById(id);
		return "Employee with Id "+id+" =deleted";
	}
	
	
	
	
	
	
	
}
