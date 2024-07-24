package com.imaginnovate.imaginnovateAppilication.service;

import java.text.ParseException;

import com.imaginnovate.imaginnovateAppilication.model.Employee;
import com.imaginnovate.imaginnovateAppilication.model.EmployeeTds;

public interface EmployeeService {
	public Employee createEmployee(Employee employee);
	public EmployeeTds getEmployeeTDS(Long employeeId) throws ParseException;
	Employee getEmployee(Long id);

}
