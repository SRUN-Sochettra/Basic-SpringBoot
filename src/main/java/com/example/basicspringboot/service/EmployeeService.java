package com.example.basicspringboot.service;

import com.example.basicspringboot.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Long employeeId);
    public Employee addEmployee(Employee employee);
    public Employee updateEmployeeById(Employee employee, Long employeeId);
    public void deleteEmployeeById(Long employeeId);
}
