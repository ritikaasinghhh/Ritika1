package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.bean.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer>
{
	
}
