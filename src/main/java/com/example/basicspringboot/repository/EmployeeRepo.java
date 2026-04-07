package com.example.basicspringboot.repository;
import com.example.basicspringboot.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeRepo {
    @Select("""
    SELECT 
        employee_id AS employeeId,
        first_name AS firstName,
        last_name AS lastName,
        email AS email,
        salary AS salary,
        department AS department,
        created_at AS createdAt
    FROM employees
""")
    List<Employee> getAllEmployees();

    @Select("""
    SELECT 
        employee_id AS employeeId,
        first_name AS firstName,
        last_name AS lastName,
        email AS email,
        salary AS salary,
        department AS department,
        created_at AS createdAt
    FROM employees
    WHERE employee_id = #{employeeId}
""")
    Employee getEmployeeById(Long employeeId);

    @Insert("""
    INSERT INTO employees(first_name, last_name, email, salary, department)
    VALUES (#{firstName}, #{lastName}, #{email}, #{salary}, #{department})
""")
    @Options(useGeneratedKeys = true, keyProperty = "employeeId", keyColumn = "employee_id")
    int insertEmployee(Employee employee);

    @Update("""
        UPDATE employees
        SET first_name = #{firstName},
            last_name = #{lastName},
            email = #{email},
            salary = #{salary},
            department = #{department}
        WHERE employee_id = #{employeeId}
""")
    void updateEmployeeById(Employee employee);

    @Delete("""
        DELETE FROM employees
        WHERE employee_id = #{employeeId}
""")
    void deleteEmployeeById(Long employeeId);
}
