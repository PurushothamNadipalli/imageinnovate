package com.imaginnovate.imaginnovateAppilication.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imaginnovate.imaginnovateAppilication.exception.EmployeeServiceException;
import com.imaginnovate.imaginnovateAppilication.model.Employee;
import com.imaginnovate.imaginnovateAppilication.model.EmployeeTds;
import com.imaginnovate.imaginnovateAppilication.repository.EmployeeRepository;
import com.imaginnovate.imaginnovateAppilication.service.EmployeeService;
import com.imaginnovate.imaginnovateAppilication.utils.SalaryCaluculationUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee getEmployee(Long id) {
		return employeeRepository.findById(id).orElseThrow(() -> new EmployeeServiceException("Employee Object not found"));
	}
	
	@Override
	public EmployeeTds getEmployeeTDS(Long employeeId) throws ParseException {
		
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		EmployeeTds employeeTds = new EmployeeTds();
		if(!employee.isPresent()) {
			throw new EmployeeServiceException("Employee Object Not found for the id" + employeeId);
		}
		calculate(employee.get(),employeeTds);
		return employeeTds;
		
	}
	
	public void calculate(Employee employee,EmployeeTds employeeTds ) throws ParseException {
        double totalSalary = caluculateYearlySalary(employee.getSalary(),employee.getDoj());
        double tax = 0;
        double cess = 0;
        double totalSalaryFortax= 0;
        if(totalSalary <= 250000) {
            tax = 0;
        }
        if(totalSalary > 250000 && totalSalary <= 500000) {
        	totalSalaryFortax = totalSalary - 250000;
            tax = tax + (double)(totalSalaryFortax*(5/100.0f));
        }
         if(totalSalary > 500000 && totalSalary <= 1000000) {
        	totalSalaryFortax = totalSalary -  500000;
            tax = tax + (double)(totalSalaryFortax*(10/100.0f))+(double)(250000*(5/100.0f)) ;
        }
         if(totalSalary > 1000000) {
        	 totalSalaryFortax = totalSalary -  1000000;
            tax = tax + (double)(totalSalaryFortax*(20/100.0f))+ (double)(500000*(10/100.0f))+(double)(250000*(5/100.0f)) ;
            if(totalSalary > 2500000) {
            	
            	cess =  (double)((totalSalary-2500000)*(2/100.0f));
            }
        }
        employeeTds.setEmployeeId(employee.getEmployeeId());
        employeeTds.setFirstName(employee.getFirstName());
        employeeTds.setLastName(employee.getLastName());
        employeeTds.setYearlySalary(totalSalary);
        employeeTds.setTaxAmount(tax);
        employeeTds.setCessAmount(cess);
    }
	
	public double caluculateYearlySalary(double salary,Date doj) throws ParseException {
		   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
	        Date date1 = simpleDateFormat.parse("2024-04-01");
	        if(doj.before(date1)) {
	        	return 12 * salary;
	        }else {
	        	long monthsBetween = ChronoUnit.MONTHS.between(
	        	        LocalDate.parse(SalaryCaluculationUtils.getStringDate(doj)).withDayOfMonth(1),
	        	        LocalDate.parse("2025-03-31").withDayOfMonth(1));
	        	System.out.println(monthsBetween);
	        	int joinDate =doj.getDate();
	        	int salariedDays = 30- joinDate;
	        	
	        	return salary * monthsBetween + (salary/30*salariedDays);
			}
	}
	
	
	

}
