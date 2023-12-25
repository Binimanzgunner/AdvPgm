package com.example.notificationproject.controller;

import com.example.notificationproject.model.Employee;
import com.example.notificationproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // new
    @RequestMapping(value = "/employee/new", method = RequestMethod.GET)
    public String EmployeeRegForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employee/new";
    }

//    save

    @RequestMapping(value = "/employee/new", method = RequestMethod.POST)
    public String registerNewEmployee(Model model, Employee employee){
        employee= employeeService.save(employee);
        model.addAttribute("supplier", employee);
        return "redirect:/employee/list";
    }

//    list

    @RequestMapping(value = "/employee/list", method = RequestMethod.GET)
    public String findAllEmployees(Model model){
        List<Employee> employees= employeeService.findAll();
        model.addAttribute("Employees", employees);
        return "employee/list";
    }

//    Delete

    @RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.GET)
    public String deleteEmployeeFromList(@PathVariable Long id){
        employeeService.deleteById(id);
        return "redirect:/employee/list";
    }
//    edit

    @RequestMapping(value = "/employee/edit/{id}", method = RequestMethod.GET)
    public String editEmployee(Model model,@PathVariable Long id){
        Employee employee= employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }


    @RequestMapping(value = "/employee/edit", method = RequestMethod.POST)
    public String editedEmployeeData(Employee employee){
        employeeService.save(employee);
        return "redirect:/employee/list";
    }
}
