package ru.skypro.employeeBook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.employeeBook.model.Employee;
import ru.skypro.employeeBook.serviceEmployee.ServiceEmployeeImpl;
import java.util.Collection;

@RequestMapping("/employee")
@RestController
public class ControllerEmployee {

    private final ServiceEmployeeImpl service;

    public ControllerEmployee(ServiceEmployeeImpl service) {

        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.findEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {

        return service.findAll();
    }


}
