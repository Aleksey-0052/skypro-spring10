package ru.skypro.employeeBook.serviceEmployee;

import org.springframework.stereotype.Service;
import ru.skypro.employeeBook.exceptions.EmployeeAlreadyAddedException;
import ru.skypro.employeeBook.exceptions.EmployeeNotFoundException;
import ru.skypro.employeeBook.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ServiceEmployeeImpl implements ServiceEmployee {

    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник с такими ФИО уже имеется");
        }

        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник с такими ФИО не найден");
        }

        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник с такими ФИО не найден");
        }

        return employee;

    }

    @Override
    public Collection<Employee> findAll() {

        return employees;
    }

}
