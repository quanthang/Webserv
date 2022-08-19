package com.example.csw.service;

import com.example.csw.model.Employees;
import com.example.csw.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void save(Employees user) {
        employeeRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employees findById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employees> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employees> findAllByNameContainsIgnoreCase(String name) {
        return employeeRepository.findAllByNameContainsIgnoreCase(name);
    }
}
