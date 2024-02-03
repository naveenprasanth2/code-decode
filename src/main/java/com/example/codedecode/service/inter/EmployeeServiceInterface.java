package com.example.codedecode.service.inter;

import com.example.codedecode.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    void deleteEmployeeById(Long id);

    Employee findEmployeeById(Long id);

    Employee updateEmployee(Employee employee);
}
