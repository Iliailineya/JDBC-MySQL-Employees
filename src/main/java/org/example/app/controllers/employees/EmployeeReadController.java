package org.example.app.controllers.employees;

import org.example.app.services.employees.EmployeeReadService;
import org.example.app.utils.AppStarter;
import org.example.app.views.employees.EmployeeReadView;

public class EmployeeReadController {
    EmployeeReadService service;
    EmployeeReadView view;

    public EmployeeReadController(EmployeeReadService service, EmployeeReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readEmployees() {
        view.getOutput(service.readEmployees());
        AppStarter.startApp();
    }
    public void readEmployeesWithPosition() {
        view.getOutput(service.readEmployeesWithPosition());
        AppStarter.startApp();
    }
}
