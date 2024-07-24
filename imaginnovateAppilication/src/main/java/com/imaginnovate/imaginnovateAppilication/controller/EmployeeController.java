package com.imaginnovate.imaginnovateAppilication.controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.imaginnovateAppilication.model.Employee;
import com.imaginnovate.imaginnovateAppilication.model.EmployeeTds;


@RestController
@RequestMapping("/v1") 
public interface EmployeeController {
	
	@PostMapping("/api/employee")
	public Employee createEmployee(@RequestBody @Valid Employee employee);
	
	@GetMapping("/api/employee/{id}")
	public Employee getEmployee(@PathVariable Long id);
	
	@GetMapping("/api/employeeTDS/{employeeId}")
	public EmployeeTds getEmployeeTDS(@PathVariable Long employeeId) throws ParseException;

	@GetMapping("/healthcheck")
	public String healthCheck();
}
