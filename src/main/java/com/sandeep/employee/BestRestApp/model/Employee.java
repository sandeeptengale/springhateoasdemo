package com.sandeep.employee.BestRestApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String employeeName;
    private String role;

    public Employee() {}

    public Employee(String name, String role) {
        this.employeeName = name;
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeName.equals(employee.employeeName) && role.equals(employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeName, role);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
