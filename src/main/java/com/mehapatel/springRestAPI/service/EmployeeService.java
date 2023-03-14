package com.mehapatel.springRestAPI.service;

import com.mehapatel.springRestAPI.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList();

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);
}
