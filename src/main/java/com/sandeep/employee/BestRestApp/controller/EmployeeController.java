package com.sandeep.employee.BestRestApp.controller;

import com.sandeep.employee.BestRestApp.exception.EmployeeNotFoundException;
import com.sandeep.employee.BestRestApp.model.Employee;
import com.sandeep.employee.BestRestApp.repository.EmployeeRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    private EmployeeModelAssembler assembler;

    public EmployeeController(EmployeeRepository repository, EmployeeModelAssembler assembler) {
        this.employeeRepository = repository;
        this.assembler = assembler;
    }
    @GetMapping("/employee")
    List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @PostMapping("/employees")
    ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee) {
        EntityModel<Employee> entityModel = assembler.toModel(employeeRepository.save(newEmployee));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @GetMapping("/employee/{id}")
    EntityModel one(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        return assembler.toModel(employee);
    }

    @PutMapping("/employee/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return employeeRepository.findById(id).map(e -> {
            e.setEmployeeName(newEmployee.getEmployeeName());
            e.setRole(newEmployee.getRole());
            return employeeRepository.save(newEmployee);
        }).orElseGet(() -> {
            newEmployee.setId(id);
            return employeeRepository.save(newEmployee);
        });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
