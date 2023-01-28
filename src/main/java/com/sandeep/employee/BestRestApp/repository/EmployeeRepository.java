package com.sandeep.employee.BestRestApp.repository;

import com.sandeep.employee.BestRestApp.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
