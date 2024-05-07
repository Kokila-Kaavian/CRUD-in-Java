package com.dbconnection.demo.controller;


import com.dbconnection.demo.model.Employee;
import com.dbconnection.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CRUDOperations {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/api/getEmployees")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/api/getempid/{id}")
    public Employee getEmpById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/api/deleteemp/{id}")
    public String deleteEmp(@PathVariable int id){
        return employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/api/getempname/{name}")
    public Employee getEmployeeByName(@PathVariable String name){
        return employeeService.getEmployeeByName(name);
    }

    @PostMapping("/api/addemployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/api/addlistofemployees")
    public List<Employee> addListOfEmployee(@RequestBody List<Employee> employees){
        return  employeeService.saveAllEmployees(employees);
    }

    @PutMapping("/api/updateemp")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

}
