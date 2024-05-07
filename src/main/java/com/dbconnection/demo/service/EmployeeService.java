package com.dbconnection.demo.service;

import com.dbconnection.demo.model.Employee;
import com.dbconnection.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    // Create (Save) new Employee -- workable for update
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Create List of employees
    public List<Employee> saveAllEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by specific Id
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).get();
    }

    // Get employee by name
    public Employee getEmployeeByName(String name){
        return  employeeRepository.findByName(name);
    }

    // Delete an employee by Id
    public String deleteEmployeeById(int id){
        employeeRepository.deleteById(id);
        return "Employee removed";
    }

    public Employee updateEmployee(Employee employee){
        Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setEmail(employee.getEmail());

        return employeeRepository.save(existingEmployee);
    }

}
