package com.mehapatel.springRestAPI.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class EmployeeResponse {

    private Long id;

    private List<String> department;

    private String employeeName;

}
