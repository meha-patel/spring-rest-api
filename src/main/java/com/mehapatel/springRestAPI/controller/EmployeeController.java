package com.mehapatel.springRestAPI.controller;

import com.mehapatel.springRestAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;

import com.mehapatel.springRestAPI.model.Employee;

import java.util.List;

//@Controller
@RestController // @Controller + @ResponseBody
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @Value("${app.name:Employee Management Application}")
    private String appName;

    @Value("${app.version:v1}")
    private String appVersion;

    @GetMapping("/version")
    public String getAppDetails() {
        return appName+"-"+appVersion;
    }

//	@RequestMapping(value="/employees", method= RequestMethod.GET)

    // http://localhost:8080/employees
    @GetMapping("/employees")
//	@ResponseBody
    public List<Employee> getEmployees() {
        return employeeService.getEmployeeList();
    }

    // http://localhost:8080/employees/1
    @GetMapping("/employees/{id}")
    public String getEmployee(@PathVariable Long id) {
        return "Fetching the employee details with id " + id;
    }

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee) {
        return "Saving the employee details to the database " + employee;
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        System.out.println("Updating the employee details with id " + id);
        return employee;
    }

    // http://localhost:8080/employees?id=1
    @DeleteMapping("/employees")
    public String deleteEmployee(@RequestParam Long id) {
        return "Deleting the employee details with id " + id;
    }
}
