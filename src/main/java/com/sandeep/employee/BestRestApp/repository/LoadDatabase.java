package com.sandeep.employee.BestRestApp.repository;

import com.sandeep.employee.BestRestApp.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class.getName());

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository) {
        return args -> {
            employeeRepository.save(new Employee("Sandeep", "dev"));
            employeeRepository.save(new Employee("Deepu", "qa"));
        };
    }
}
