package com.example.workhome24;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String lastName) {
        return  employeeService.add(firstName, lastName);
    }
    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName) {
        return  employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public String find(@RequestParam String firstName, @RequestParam String lastName) {
        return  employeeService.find(firstName, lastName);
    }
}
