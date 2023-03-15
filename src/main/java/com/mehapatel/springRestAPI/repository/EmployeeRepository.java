package com.mehapatel.springRestAPI.repository;

import com.mehapatel.springRestAPI.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    List<Employee> findByName(String name);

//    List<Employee> findByNameAndLocation(String name, String location);

//    List<Employee> findByNameContaining(String keyword, Sort sort);
//    List<Employee> findByNameLike(String "%"+keyword+"%");

//    @Query("SELECT e FROM Employee e WHERE e.name = :name OR e.location = :location")
//    List<Employee> getEmployeesByNameOrLocation(String name, String location);

//    @Transactional // If we want to modify the database like:- add, update, delete
//    @Modifying // If we want to modify the database like:- add, update, delete
//    @Query("DELETE FROM Employee e WHERE e.name = :name")
//    Integer deleteByEmployeeName(String name);

//List<Employee> findByDepartmentName(String name);

//@Query("SELECT e FROM Employee e WHERE department.name = :name")
//List<Employee> getEmployeesByDeptName(String name);

}
