package com.mehapatel.springRestAPI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity // by using this, this class represents the database table in our application
@Table(name = "tbl_department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

//    @OneToOne(mappedBy = "department")
//    private Employee employee;

}
