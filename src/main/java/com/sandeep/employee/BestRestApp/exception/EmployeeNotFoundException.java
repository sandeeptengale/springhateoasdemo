package com.sandeep.employee.BestRestApp.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Could not find the employee: " + id);
    }
}
