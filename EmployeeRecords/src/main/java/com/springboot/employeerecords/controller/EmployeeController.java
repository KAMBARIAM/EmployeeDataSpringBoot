package com.springboot.employeerecords.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeerecords.dao.EmployeeRepo;
import com.springboot.employeerecords.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepo empRepo;

	@GetMapping("/welcome/{name}")
	public String welcomeMessage(@PathVariable("name") String name)
	{
		return "Welcome " + name;
	}

	@PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee emp)
    {
		empRepo.save(emp);
		return emp;    	
    }
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") int id)
	{
	    return empRepo.findOne(id);
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAll()
	{
		return empRepo.findAll();
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee emp)
	{
		empRepo.save(emp);
		return emp;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id)
	{
		empRepo.delete(id);
		return "Employee " + id + " deleted";
	}
}
