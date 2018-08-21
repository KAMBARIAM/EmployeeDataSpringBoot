package com.springboot.employeerecords.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.employeerecords.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> 
{

}
