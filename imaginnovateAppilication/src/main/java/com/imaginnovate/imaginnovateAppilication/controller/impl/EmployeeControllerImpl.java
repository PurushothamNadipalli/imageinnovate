package com.imaginnovate.imaginnovateAppilication.controller.impl;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.imaginnovateAppilication.controller.EmployeeController;
import com.imaginnovate.imaginnovateAppilication.exception.EmployeeServiceException;
import com.imaginnovate.imaginnovateAppilication.model.Employee;
import com.imaginnovate.imaginnovateAppilication.model.EmployeeTds;
import com.imaginnovate.imaginnovateAppilication.service.EmployeeService;
import com.imaginnovate.imaginnovateAppilication.utils.SalaryCaluculationUtils;


@RestController
public class EmployeeControllerImpl implements EmployeeController{

	@Autowired
	EmployeeService employeeService;
	
	public Employee createEmployee(@RequestBody @Valid Employee employee) {
		
		if(!SalaryCaluculationUtils.validatePhoneNumbers(employee)) {
			throw new EmployeeServiceException("Invalid phone number");
		}
		if(!SalaryCaluculationUtils.validateEmail(employee)) {
			throw new EmployeeServiceException("Invalid email address");
		}
		return employeeService.createEmployee(employee);
		
	}
	
	public EmployeeTds getEmployeeTDS(@PathVariable Long employeeId) throws ParseException{
		return employeeService.getEmployeeTDS(employeeId);
		
	}

	public String healthCheck() {
		return "OK";
	}

	@Override
	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		return employeeService.getEmployee(id);
	}
}
