package com.mehapatel.springRestAPI.controller;

import com.mehapatel.springRestAPI.model.Department;
import com.mehapatel.springRestAPI.repository.DepartmentRepository;
import com.mehapatel.springRestAPI.repository.EmployeeRepository;
import com.mehapatel.springRestAPI.request.EmployeeRequest;
import com.mehapatel.springRestAPI.response.EmployeeResponse;
import com.mehapatel.springRestAPI.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;

import com.mehapatel.springRestAPI.model.Employee;

import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController // @Controller + @ResponseBody
//@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository eRepo;

    @Autowired
    private DepartmentRepository dRepo;

    @Value("${app.name:Employee Management Application}")
    private String appName;

    @Value("${app.version:v1}")
    private String appVersion;

    @GetMapping("/version")
    public String getAppDetails() {
        return appName + "-" + appVersion;
    }

//	@RequestMapping(value="/employees", method= RequestMethod.GET)

    // http://localhost:8080/employees

    //  pagination start...

//    @GetMapping("/employees")
//	@ResponseBody
//    public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
//        return new ResponseEntity<List<Employee>>(employeeService.getEmployeeList(pageNumber, pageSize), HttpStatus.OK);
//    }

    // pagination end...

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeResponse>> getEmployees() {
        List<Employee> list = eRepo.findAll();
        List<EmployeeResponse> responseList = new ArrayList<>();
        list.forEach(e->{
            EmployeeResponse eResponse = new EmployeeResponse();
            eResponse.setId(e.getId());
            eResponse.setEmployeeName(e.getName());
            List<String> depts = new ArrayList<>();
            for(Department d: e.getDepartments()) {
                depts.add(d.getName());
            }
            eResponse.setDepartment(depts);
            responseList.add((eResponse));
        });
        return new ResponseEntity<List<EmployeeResponse>>(responseList, HttpStatus.OK);
    }

    // http://localhost:8080/employees/1
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeRequest eRequest) {
//        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
//        Department dept = new Department();
//        dept.setName(eRequest.getDepartment().toString());
//
//        dept = dRepo.save(dept);
//
//        Employee employee = new Employee(eRequest);
//        employee.setDepartment(dept);
//
//        return new ResponseEntity<Employee>(eRepo.save(employee), HttpStatus.CREATED);

        Employee employee = new Employee(eRequest);
        employee = eRepo.save(employee);

        for (String s : eRequest.getDepartment()) {
            Department d = new Department();
            d.setName(s);
            d.setEmployee(employee);

            dRepo.save(d);
        }
        return new ResponseEntity<String>("Record saved successfully", HttpStatus.CREATED);

    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    // http://localhost:8080/employees?id=1
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

//    @GetMapping("/employees/filter/{name}")
//    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable String name) {
////        return new ResponseEntity<List<Employee>>(eRepo.findByDepartmentName(name),HttpStatus.OK);
//        return new ResponseEntity<List<Employee>>(eRepo.getEmployeesByDeptName(name), HttpStatus.OK);
//    }

//    @GetMapping("/employees/filterByName")
//    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {
//        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByName(name), HttpStatus.OK);
//    }


//    @GetMapping("/employees/filterByNameAndLocation")
//    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name, @RequestParam String location) {
//        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameAndLocation(name, location), HttpStatus.OK);
//    }

//    @GetMapping("/employees/filterByKeyword")
//    public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name) {
//        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByKeyword(name), HttpStatus.OK);
//    }

//    @GetMapping("/employees/{name}/{location}")
//    public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation(@PathVariable String name, @PathVariable String location) {
//        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameOrLocation(name, location), HttpStatus.OK);
//    }

//    @DeleteMapping("/employees/delete/{name}")
//    public ResponseEntity<String> deleteByEmployeeName(@PathVariable String name) {
//        return new ResponseEntity<String>(employeeService.deleteByEmployeeName(name) + "No. of Records deleted", HttpStatus.OK);
//    }

}
