package com.springboot.simpleapi.controller;

import com.springboot.simpleapi.model.Employee;
import com.springboot.simpleapi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController (EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }


    // Create Employee REST API
    @PostMapping("save-employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // Get all employees REST API
    @GetMapping("all-employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee by ID REST API
    @GetMapping("get-employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    // Update employee REST API
    @PutMapping("update-employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId,
                                                   @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeId), HttpStatus.OK);
    }

    // Delete employee by ID REST API
    @DeleteMapping("delete-employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {

        // Delete employee from DB
        employeeService.deleteEmployee(id);

        // Show message
        String message = "Employee with ID: " + id + " deleted successfully!";
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
}
