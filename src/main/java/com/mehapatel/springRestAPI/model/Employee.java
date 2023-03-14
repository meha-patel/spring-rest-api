package com.mehapatel.springRestAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Setter
@Getter
@ToString
@Entity // by using this, this class represents the database table in our application
@Table(name = "tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Long id;

    //	@JsonProperty("full_name")
//    @Column(name = "name") // not necessary if there's a same column name
    @NotBlank(message = "Name should not be NULL.") // it checks for null, empty and blanks
    private String name;

    //	@JsonIgnore
//    @Column(name = "age")
    private Long age = 0L;

    //    @Column(name = "location")
    private String location;

    //    @Column(name = "email")
    @Email(message = "Please enter the valid email address.")
    private String email;

    //    @Column(name = "department")
    @NotBlank(message = "Department should not be NULL.") // it checks for null, empty and blanks
    private String department;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false) // necessary for same column names
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
