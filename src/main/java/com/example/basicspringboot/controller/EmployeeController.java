package com.example.basicspringboot.controller;

import com.example.basicspringboot.model.ApiResponse;
import com.example.basicspringboot.model.Employee;
import com.example.basicspringboot.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // GET /employees/all
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Employee>>> getAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();

        ApiResponse<List<Employee>> response = new ApiResponse<>(
                true,
                "All employees fetched successfully",
                allEmployees
        );

        return ResponseEntity.ok(response);
    }

    // POST /employees/add
    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Employee>> addEmployee(@RequestBody Employee employee) {
        Employee addedEmployee = employeeService.addEmployee(employee);

        ApiResponse<Employee> response = new ApiResponse<>(
                true,
                "Employee added successfully",
                addedEmployee
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getEmployeeById(@PathVariable("id") Long employeeId) {
        Employee gottenEmployeeById = employeeService.getEmployeeById(employeeId);

        if (gottenEmployeeById == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(
                    false,
                    "Null employee",
                    null
            ));
        }

        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "Employee " + employeeId + " fetched successfully",
                gottenEmployeeById
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> updateEmployeeById(@RequestBody Employee employee, @PathVariable("id") Long employeeId) {
        Employee updatedEmployee = employeeService.updateEmployeeById(employee, employeeId);

        if (updatedEmployee == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(
                    false,
                    "Null employee",
                    null
            ));
        }

        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "Employee updated successfully",
                updatedEmployee
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> deleteEmployeeById(@PathVariable("id") Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);

        if (employee == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(
                    false,
                    "Null employee",
                    null
            ));
        }

        employeeService.deleteEmployeeById(employeeId);

        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "Employee deleted successfully",
                employee
        ));
    }
}
