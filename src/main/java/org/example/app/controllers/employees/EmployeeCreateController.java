package org.example.app.controllers.employees;

import org.example.app.entities.Employee;
import org.example.app.services.employees.EmployeeCreateService;
import org.example.app.utils.AppStarter;
import org.example.app.views.employees.EmployeeCreateView;

public class EmployeeCreateController {

    EmployeeCreateView view;
    EmployeeCreateService service;

    public EmployeeCreateController(EmployeeCreateService service, EmployeeCreateView view) {
        this.service = service;
        this.view = view;
    }

    public void createEmployee() {
        Employee employee = view.getData();
        String result = service.createEmployee(employee);
        view.getOutput(result);
        AppStarter.startApp();
    }
}
