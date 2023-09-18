package org.example.app.services.employees;

import org.example.app.entities.Employee;
import org.example.app.exceptions.PositionCreateException;
import org.example.app.repositories.employees.EmployeeCreateRepository;
import org.example.app.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class EmployeeCreateService {

    EmployeeCreateRepository repository;

    public EmployeeCreateService(EmployeeCreateRepository repository) {
        this.repository = repository;
    }

    public String createEmployee(Employee employee) {

        // Map для збирання помилок
        Map<String, String> errors = new HashMap<>();

        if (employee.getLastName().isEmpty())
            errors.put("last_name", Constants.INPUT_REQ_MSG);
        if (employee.getFirstName().isEmpty())
            errors.put("first_name", Constants.INPUT_REQ_MSG);
        if (employee.getBirthDate().isEmpty())
            errors.put("birth_date", Constants.INPUT_REQ_MSG);
        if (employee.getPhone().isEmpty())
            errors.put("phone", Constants.INPUT_REQ_MSG);


        if (!errors.isEmpty()) {
            try {
                throw new PositionCreateException("Check inputs", errors);
            } catch (PositionCreateException e) {
                return e.getErrors(errors);
            }
        }

        return repository.createEmployee(employee);
    }
}
