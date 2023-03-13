package com.mehapatel.springRestAPI.service;

import com.mehapatel.springRestAPI.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public static List<Employee> list = new ArrayList<>();

    static {
        Employee e = new Employee();
        e.setName("Meha");
        e.setAge(24L);
        e.setLocation("Canada");
        e.setEmail("meha@gmail.com");
        e.setDepartment("Software Development");
        list.add(e);
        list.add(e);
        list.add(e);
        list.add(e);

    }

    @Override
    public List<Employee> getEmployeeList() {
        return list;
    }
}
