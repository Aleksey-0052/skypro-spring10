package ru.skypro.employeeBook.serviceEmployee;

import org.springframework.stereotype.Service;
import ru.skypro.employeeBook.exceptions.EmployeeAlreadyAddedException;
import ru.skypro.employeeBook.exceptions.EmployeeNotFoundException;
import ru.skypro.employeeBook.model.Employee;
import java.util.*;

@Service
public class ServiceEmployeeImpl implements ServiceEmployee {

    private final Map<String, Employee> employees = new HashMap<>();
    // Заменяем список на мапу

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.containsKey(employee.getFullName())) {
            // contains(employee) заменяем на containsKey(employee.getFullName())
            throw new EmployeeAlreadyAddedException("Сотрудник с такими ФИО уже имеется");
        }

        employees.put(employee.getFullName(), employee);
        // add(employee) заменяем на put(employee.getFullName(), employee)
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.containsKey(employee.getFullName())) {
            // contains(employee) заменяем на containsKey(employee.getFullName())
            throw new EmployeeNotFoundException("Сотрудник с такими ФИО не найден");
        }

        employees.remove(employee.getFullName());
        // remove(employee) заменяем на remove(employee.getFullName())
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        // Поиск сотрудника по ключу
        // Employee employee = employees.get(employee.getFullName());

        if (!employees.containsKey(employee.getFullName())) {
            // contains(employee) заменяем на containsKey(employee.getFullName())
            throw new EmployeeNotFoundException("Сотрудник с такими ФИО не найден");
        }

        return employee;

    }

    @Override
    public Collection<Employee> findAll() {

        return employees.values();
        // return employees заменяем на return employees.values(), то есть добавляем метод
        // values()
    }

}
