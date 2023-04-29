package com.springboot.simpleapi.service.impl;

import com.springboot.simpleapi.exception.ResourceNotFoundException;
import com.springboot.simpleapi.model.Employee;
import com.springboot.simpleapi.repository.EmployeeRepo;
import com.springboot.simpleapi.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    public EmployeeImpl(EmployeeRepo employeeRepo) {
        super();
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
//        Optional<Employee> employee = employeeRepo.findById(id);
//        if (employee.isPresent()) {
//            return employee.get();
//        } else {
//            throw new ResourceNotFoundException("Employee", "ID", id);
//        }

        return employeeRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "ID", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // Check id is exists DB or not
        Employee existingEmployee = employeeRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        // Save existing employee to DB.
        employeeRepo.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        // Check id is exists DB or not
        Employee existingEmployee = employeeRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
        employeeRepo.deleteById(id);
    }
}
