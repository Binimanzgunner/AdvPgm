package com.example.notificationproject.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String name;
    private int age;
    private String department;
    private String position;

    public Employee(String name, int age, String department, String position) {
        super();
        this.name = name;
        this.age = age;
        this.department = department;
        this.position = position;
    }

    public Employee() {

    }
}
