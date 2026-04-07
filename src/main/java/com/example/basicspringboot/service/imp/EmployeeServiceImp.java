package com.example.basicspringboot.service.imp;

import com.example.basicspringboot.model.Employee;
import com.example.basicspringboot.repository.EmployeeRepo;
import com.example.basicspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImp(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepo.getEmployeeById(employeeId);
    }
    @Override
    public Employee addEmployee(Employee employee) {
        employeeRepo.insertEmployee(employee);
        return employeeRepo.getEmployeeById(employee.getEmployeeId());
    }

    @Override
    public Employee updateEmployeeById(Employee employee, Long employeeId) {
        Employee employeeToUpdate = employeeRepo.getEmployeeById(employeeId);
        if (employeeToUpdate != null) {
            employee.setEmployeeId(employeeId);
            employeeRepo.updateEmployeeById(employee);
            return employee;
        }
        return null;
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepo.deleteEmployeeById(employeeId);
    }
}
