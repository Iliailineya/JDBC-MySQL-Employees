package org.example.app.controllers.employees;

import org.example.app.services.employees.EmployeeService;
import org.example.app.views.employees.EmployeeView;

public class EmployeeController {

    EmployeeService service;
    EmployeeView view;

    public EmployeeController(EmployeeView view, EmployeeService service) {
        this.service = service;
        this.view = view;
    }

    public void runEmployees() {
        filterChoice(view.chooseOption());
    }

    private void filterChoice(int choice) {
        switch (choice) {
            case 1 -> service.createEmployee();
            case 2 -> service.readEmployees();
            case 3 -> service.readEmployeesWithPosition();
            case 0 -> view.close();
            default -> service.getNoSuchOption(choice);
        }
    }
}
