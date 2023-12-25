package com.example.notificationproject.serviceImplementation;

import com.example.notificationproject.model.Employee;
import com.example.notificationproject.repository.EmployeeRepository;
import com.example.notificationproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("EmployeeService")
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> optionalEmployee=employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
