package org.example.app.services;

import org.example.app.controllers.employees.EmployeeController;
import org.example.app.controllers.positions.PositionController;
import org.example.app.services.employees.EmployeeService;
import org.example.app.services.positions.PositionService;
import org.example.app.views.employees.EmployeeView;
import org.example.app.views.positions.PositionView;

public class AppService extends Services {

    public void getPositions() {
        PositionView view = new PositionView();
        PositionService service = new PositionService();
        PositionController controller = new PositionController(view, service);
        controller.runPositions();
    }

    public void getEmployees() {
        EmployeeView view = new EmployeeView();
        EmployeeService service = new EmployeeService();
        EmployeeController controller = new EmployeeController(view, service);
        controller.runEmployees();
    }
}