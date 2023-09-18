package org.example.app.services.positions;

import org.example.app.entities.Employee;
import org.example.app.entities.Position;
import org.example.app.entities.PositionWithEmployeesDTO;
import org.example.app.repositories.positions.PositionReadRepository;
import org.example.app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PositionReadService {

    PositionReadRepository repository;

    public PositionReadService(PositionReadRepository repository) {
        this.repository = repository;
    }

    public String readPositions() {

        // Отримуємо дані
        List<Position> list = repository.readPositions();

        // Якщо колекція не null, формуємо текст.
        // Інакше повідомлення про відсутність даних.
        if (list != null) {
            // Якщо колекція не порожня, формуємо текст.
            // Інакше повідомлення про відсутність даних.
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((prop) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") id: ")
                                .append(prop.getId())
                                .append(", ")
                                .append(prop.getName())
                                .append("\n")
                );
                return "\n_ Positions ___________\n" + stringBuilder;
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }

    public String readPositionWithEmployees() {
        List<PositionWithEmployeesDTO> positionsWithEmployees = repository.readPositionWithEmployees();

        StringBuilder result = new StringBuilder("\n_ Positions with Employees ___________\n");

        if (positionsWithEmployees.isEmpty()) {
            return Constants.DATA_ABSENT_MSG;
        } else {
            AtomicInteger count = new AtomicInteger(0);

            for (PositionWithEmployeesDTO positionDTO : positionsWithEmployees) {
                result.append(count.incrementAndGet())
                        .append(") Position ID: ")
                        .append(positionDTO.getPositionId())
                        .append(", Position Name: ")
                        .append(positionDTO.getPositionName())
                        .append("\n");

                List<Employee> employees = positionDTO.getEmployees();
                if (!employees.isEmpty()) {
                    for (Employee employee : employees) {
                        result.append("   - Employee ID: ")
                                .append(employee.getId())
                                .append(", Last Name: ")
                                .append(employee.getLastName())
                                .append(", First Name: ")
                                .append(employee.getFirstName())
                                .append("\n");
                    }
                } else {
                    result.append("   No employees for this position.\n");
                }
            }
        }

        return result.toString();
    }
}