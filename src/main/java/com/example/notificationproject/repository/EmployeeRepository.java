package com.example.notificationproject.repository;

import com.example.notificationproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("EmployeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
