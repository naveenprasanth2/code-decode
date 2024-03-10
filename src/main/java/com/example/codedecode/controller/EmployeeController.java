package com.example.codedecode.controller;

import com.example.codedecode.entity.Employee;
import com.example.codedecode.service.inter.EmployeeServiceInterface;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
@Log4j2
public class EmployeeController {
    private EmployeeServiceInterface employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        log.info("Employee is created");
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> allEmployee = employeeService.getAllEmployees();
        return new ResponseEntity<>(allEmployee, HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
      Employee employee =  employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("employee deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
      Employee updatedEmployee =  employeeService.updateEmployee( employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
}
