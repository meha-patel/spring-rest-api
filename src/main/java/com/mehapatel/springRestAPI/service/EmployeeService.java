package com.mehapatel.springRestAPI.service;

import com.mehapatel.springRestAPI.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList(int pageNumber, int pageSize);

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);

//    List<Employee> getEmployeesByName(String name);

//    List<Employee> getEmployeesByNameAndLocation(String name, String location);

//    List<Employee> getEmployeesByKeyword(String name);

//    List<Employee> getEmployeesByNameOrLocation(String name, String location);

//    Integer deleteByEmployeeName(String name);

}
