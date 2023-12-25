package com.example.notificationproject.service;

import com.example.notificationproject.model.Employee;

import java.util.List;

public interface EmployeeService {
    public abstract List<Employee> findAll();
    public abstract Employee findById(Long id);
    public abstract void deleteById(Long id);
    public abstract Employee save(Employee employee);
}
