package com.coolwork.projects.dao;

import java.util.List;

import com.coolwork.projects.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager)
	{
		this.entityManager =theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		TypedQuery<Employee> myQuery = entityManager.createQuery("from Employee",Employee.class);
		
	  List<Employee> myEmployees = myQuery.getResultList();
		
		return myEmployees;
	}

	@Override
	public Employee findById(int id) {
	
		Employee myemp = entityManager.find(Employee.class, id);
		
		return myemp;
	}

	@Override
	public Employee Save(Employee emp) {

     Employee Employee = entityManager.merge(emp);
		return Employee;
	}

	@Override
	public void DeleteById(int id) {
		//find using id and then delete
		
		Employee theEmployee = entityManager.find(Employee.class, id);
		
		entityManager.remove(theEmployee);
	}

}
