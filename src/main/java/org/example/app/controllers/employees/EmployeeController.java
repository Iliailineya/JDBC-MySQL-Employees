package org.example.app.controllers.employees;

import org.example.app.entities.Employee;
import org.example.app.services.employees.EmployeeService;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.views.employees.EmployeeCreateView;
import org.example.app.views.employees.EmployeeReadView;

public class EmployeeController {

    EmployeeService service;
    EmployeeCreateView createView;
    EmployeeReadView readView;

    public EmployeeController(EmployeeService service, EmployeeCreateView createView, EmployeeReadView readView) {
        this.service = service;
        this.createView = createView;
        this.readView = readView;
    }

    public void createEmployee() {
        Employee employee = createView.getEmployeeInput();
        String result = service.createEmployee(employee);
        createView.showResult(result);
        AppStarter.startApp();
    }

    public void readEmployees() {
        String result = service.readEmployees();
        readView.showEmployees(result);
        AppStarter.startApp();
    }
}
