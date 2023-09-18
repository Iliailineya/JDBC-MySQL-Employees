package org.example.app.services.employees;


import org.example.app.controllers.employees.EmployeeCreateController;
import org.example.app.controllers.employees.EmployeeReadController;
import org.example.app.repositories.employees.EmployeeCreateRepository;
import org.example.app.repositories.employees.EmployeeReadRepository;
import org.example.app.services.Services;
import org.example.app.views.employees.EmployeeCreateView;
import org.example.app.views.employees.EmployeeReadView;

public class EmployeeService extends Services {
    public void createEmployee() {
        EmployeeCreateRepository repository = new EmployeeCreateRepository();
        EmployeeCreateService service = new EmployeeCreateService(repository);
        EmployeeCreateView view = new EmployeeCreateView();
        EmployeeCreateController controller = new EmployeeCreateController(service, view);
        controller.createEmployee();
    }

    public void readEmployees() {
        EmployeeReadRepository repository = new EmployeeReadRepository();
        EmployeeReadService service = new EmployeeReadService(repository);
        EmployeeReadView view = new EmployeeReadView();
        EmployeeReadController controller = new EmployeeReadController(service, view);
        controller.readEmployees();
    }
}
