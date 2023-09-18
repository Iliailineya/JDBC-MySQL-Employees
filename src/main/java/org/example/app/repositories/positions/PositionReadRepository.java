package org.example.app.repositories.positions;

import org.example.app.database.DBConn;
import org.example.app.entities.Employee;
import org.example.app.entities.Position;
import org.example.app.entities.PositionWithEmployeesDTO;
import org.example.app.utils.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PositionReadRepository {

    List<Position> list;

    public List<Position> readPositions() {

        try (Statement stmt = DBConn.connect().createStatement()) {

            list = new ArrayList<>();

            String sql = "SELECT id, name FROM " + Constants.TABLE_POSITIONS;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(Position.fromResultSet(rs));
            }

            return list;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    public List<PositionWithEmployeesDTO> readPositionWithEmployees() {
        List<PositionWithEmployeesDTO> result = new ArrayList<>();

        // Выполняем запрос к базе данных для объединения таблиц
        String sql = "SELECT p.id AS position_id, p.name AS position_name, e.id AS employee_id, e.last_name, e.first_name, e.birth_date, e.phone, e.salary FROM positions p LEFT JOIN employees e ON p.id = e.position_id";

        try (Statement stmt = DBConn.connect().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            int currentPosId = -1;
            PositionWithEmployeesDTO currentDTO = null;

            while (rs.next()) {
                int posId = rs.getInt("position_id");

                if (currentPosId != posId) {
                    // Создаем новый DTO для новой позиции
                    currentDTO = new PositionWithEmployeesDTO();
                    currentDTO.setPositionId(posId);
                    currentDTO.setPositionName(rs.getString("position_name"));
                    currentDTO.setEmployees(new ArrayList<>());
                    result.add(currentDTO);
                    currentPosId = posId;
                }

                if (rs.getInt("employee_id") != 0) {
                    // Добавляем сотрудника к текущей позиции
                    Employee employee = new Employee();
                    employee.setId(rs.getInt("employee_id"));
                    employee.setLastName(rs.getString("last_name"));
                    employee.setFirstName(rs.getString("first_name"));
                    employee.setBirthDate(rs.getString("birth_date"));
                    employee.setPhone(rs.getString("phone"));
                    employee.setSalary(rs.getDouble("salary"));
                    if (currentDTO != null) {
                        currentDTO.getEmployees().add(employee);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}