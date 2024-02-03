package com.example.codedecode.controller;

import com.example.codedecode.entity.Employee;
import com.example.codedecode.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/code")
@AllArgsConstructor
public class CodeDecodeController {
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        System.out.println("getting all employees");
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.ACCEPTED);
    }


}
