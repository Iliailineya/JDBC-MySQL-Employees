package org.example.app.services.employees;

import org.example.app.entities.Employee;
import org.example.app.entities.EmployeePositionDTO;
import org.example.app.repositories.employees.EmployeeReadRepository;
import org.example.app.utils.Constants;

import java.util.List;

public class EmployeeReadService {

    EmployeeReadRepository repository;

    public EmployeeReadService(EmployeeReadRepository repository) {
        this.repository = repository;
    }

    public String readEmployees() {
        List<Employee> employees = repository.readEmployees();

        if (employees.isEmpty()) {
            return Constants.DATA_ABSENT_MSG;
        } else {
            StringBuilder result = new StringBuilder();
            int count = 0;
            for (Employee employee : employees) {
                result.append("\n")
                        .append(++count)
                        .append(") ID: ").append(employee.getId())
                        .append(", Last Name: ").append(employee.getLastName())
                        .append(", First Name: ").append(employee.getFirstName())
                        .append(", Birth Date: ").append(employee.getBirthDate())
                        .append(", Position ID: ").append(employee.getPositionId())
                        .append(", Phone: ").append(employee.getPhone())
                        .append(", Salary: ").append(employee.getSalary());
            }
            return "\n_ Employees ___________" + result;
        }
    }

    public String readEmployeesWithPosition() {
        List<EmployeePositionDTO> employees = repository.readEmployeesWithPosition();

        if (employees.isEmpty()) {
            return Constants.DATA_ABSENT_MSG;
        } else {
            StringBuilder result = new StringBuilder("\n_ Employees with position ___________");
            int count = 0;
            for (EmployeePositionDTO employee : employees) {
                result.append("\n")
                        .append(++count)
                        .append(") ID: ").append(employee.getId())
                        .append(", Last Name: ").append(employee.getLastName())
                        .append(", First Name: ").append(employee.getFirstName())
                        .append(", Birth Date: ").append(employee.getBirthDate())
                        .append(", Position ID: ").append(employee.getPositionId())
                        .append(", Phone: ").append(employee.getPhone())
                        .append(", Salary: ").append(employee.getSalary())
                        .append(", Position Name: ").append(employee.getPositionName());
            }
            return result.toString();
        }
    }
}
