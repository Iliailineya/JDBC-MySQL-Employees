package org.example.app.views.employees;

import org.example.app.entities.Employee;
import org.example.app.utils.InputReader;
import org.example.app.views.ItemView;

public class EmployeeCreateView extends ItemView {
    private final InputReader inputReader;

    public EmployeeCreateView() {
        this.inputReader = new InputReader();
    }

    public Employee getData() {
        System.out.println("Enter employee details:");
        Employee employee = new Employee();
        employee.setLastName(inputReader.readString("Last Name: "));
        employee.setFirstName(inputReader.readString("First Name: "));
        employee.setBirthDate(inputReader.readString("Birth Date (YYYY-MM-DD): "));
        employee.setPositionId(inputReader.readInt("Position ID: "));
        employee.setPhone(inputReader.readString("Phone: "));
        employee.setSalary(inputReader.readDouble("Salary: "));
        return employee;
    }
}