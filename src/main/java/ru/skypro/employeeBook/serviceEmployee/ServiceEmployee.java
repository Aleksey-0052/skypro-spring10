package ru.skypro.employeeBook.serviceEmployee;

import ru.skypro.employeeBook.model.Employee;

import java.util.Collection;


public interface ServiceEmployee {

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> findAll();


}
