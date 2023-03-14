package com.mehapatel.springRestAPI.service;

import com.mehapatel.springRestAPI.model.Employee;
import com.mehapatel.springRestAPI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//    public static List<Employee> list = new ArrayList<>();
//    static {
//        Employee e = new Employee();
//        e.setName("Meha");
//        e.setAge(24L);
//        e.setLocation("Canada");
//        e.setEmail("meha@gmail.com");
//        e.setDepartment("Software Development");
//        list.add(e);
//        list.add(e);
//        list.add(e);
//        list.add(e);
//    }

    @Autowired
    private EmployeeRepository eRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = eRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RuntimeException("Employee not found with id " + id);
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        eRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeeList() {
//        eRepository.findAllByD
        return eRepository.findAll();
    }
}
