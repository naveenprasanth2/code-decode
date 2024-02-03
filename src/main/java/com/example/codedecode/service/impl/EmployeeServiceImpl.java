package com.example.codedecode.service.impl;

import com.example.codedecode.entity.Employee;
import com.example.codedecode.exception.BusinessException;
import com.example.codedecode.repository.EmployeeRepo;
import com.example.codedecode.service.inter.EmployeeServiceInterface;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.StringTemplate.STR;

@Service
@AllArgsConstructor
@Log4j2
public class EmployeeServiceImpl implements EmployeeServiceInterface {
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> employees = employeeRepo.findAll();
        if (employees.isEmpty()) {
            throw new BusinessException("604", "The employee list is empty");
        } else {
            return employees;
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {
        try {
            if (employee.getName().isEmpty() || employee.getName().isBlank()) {
                throw new BusinessException("601", "Please send a proper employee body please");
            }
            return employeeRepo.save(employee);

        } catch (IllegalArgumentException illegalArgumentException) {
            throw new BusinessException("602", STR."Given employer name is null \{illegalArgumentException.getMessage()}");
        } catch (Exception exception) {
            throw new BusinessException("603", STR."Some issue has occured at service layer \{exception.getMessage()}");
        }

    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepo.findById(id).orElseThrow();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
}
