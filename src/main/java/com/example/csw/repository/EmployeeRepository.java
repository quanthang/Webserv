package com.example.csw.repository;

import com.example.csw.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
    List<Employees> findAllByName(String name);
    List<Employees> findAllByNameContainsIgnoreCase(String name);
    List<Employees> findAllByNameAndSalary(String name, String email);
    List<Employees> findAllByNameOrderBySalaryAsc(String name);
}