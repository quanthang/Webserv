package com.example.csw.controller;

import com.example.csw.service.EmployeeService;
import com.example.csw.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "employee", method = RequestMethod.GET)
    public ResponseEntity<List<Employees>> findAllEmployee() {
        List<Employees> list = employeeService.findAll();
        if (list.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employees>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Employees> save(@RequestBody Employees employees) {
        employeeService.save(employees);
        return new ResponseEntity<Employees>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Employees> update(@PathParam("id") Integer id, @RequestBody Employees employees) {
        Employees oldEmployees = employeeService.findById(id);
        oldEmployees.setName(employees.getName());
        oldEmployees.setSalary(employees.getSalary());
        employeeService.save(oldEmployees);
        return new ResponseEntity<Employees>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employees> updateE(@PathVariable(value = "id") Integer id, @RequestBody Employees employees) {
        Employees oldEmployees = employeeService.findById(id);
        oldEmployees.setName(employees.getName());
        oldEmployees.setSalary(employees.getSalary());
        employeeService.save(oldEmployees);
        return new ResponseEntity<Employees>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employees> delete(@PathVariable(value = "id") Integer id) {
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "find", method = RequestMethod.GET)
    public ResponseEntity<List<Employees>> findEmployeesByName(@PathParam("name") String name) {
        List<Employees> list = employeeService.findAllByNameContainsIgnoreCase(name);
        if (list.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employees>>(list, HttpStatus.OK);
    }
}