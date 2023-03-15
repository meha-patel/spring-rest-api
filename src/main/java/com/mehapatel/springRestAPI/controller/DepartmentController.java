package com.mehapatel.springRestAPI.controller;

import com.mehapatel.springRestAPI.model.Department;
import com.mehapatel.springRestAPI.repository.DepartmentRepository;
import com.mehapatel.springRestAPI.response.DepartmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class DepartmentController {

    @Autowired
    private DepartmentRepository dRepo;

    @GetMapping("/departments")
    public List<DepartmentResponse> getDepartments() {
       List<Department> depts=dRepo.findAll();
       List<DepartmentResponse> list = new ArrayList<>();
       depts.forEach(d -> {
           DepartmentResponse dResponse = new DepartmentResponse();
           dResponse.setDepartmentName(d.getName());
           dResponse.setId(d.getId());
           dResponse.setEmployeeName(d.getEmployee().getName());
           list.add(dResponse);
       });
       return list;
    }
}
