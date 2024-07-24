package com.imaginnovate.imaginnovateAppilication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.imaginnovateAppilication.model.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}