package org.example.app.repositories.employees;

import org.example.app.database.DBConn;
import org.example.app.entities.Employee;
import org.example.app.entities.EmployeePositionDTO;
import org.example.app.utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeReadRepository {
    List<Employee> list;

    public List<Employee> readEmployees() {

        try (Statement stmt = DBConn.connect().createStatement()) {

            list = new ArrayList<>();

            String sql = "SELECT * FROM " + Constants.TABLE_EMPLOYEES;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(Employee.fromResultSet(rs));
            }

            return list;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    public List<EmployeePositionDTO> readEmployeesWithPosition() {
        List<EmployeePositionDTO> result = new ArrayList<>();

        // Выполняем запрос к базе данных для объединения таблиц
        String sql = "SELECT e.id, e.last_name, e.first_name, e.birth_date, e.position_id, e.phone, e.salary, p.name AS position_name FROM employees e INNER JOIN positions p ON e.position_id = p.id";

        try (Statement stmt = DBConn.connect().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                EmployeePositionDTO dto = new EmployeePositionDTO();
                dto.setId(rs.getInt("id"));
                dto.setLastName(rs.getString("last_name"));
                dto.setFirstName(rs.getString("first_name"));
                dto.setBirthDate(rs.getString("birth_date"));
                dto.setPositionId(rs.getInt("position_id"));
                dto.setPhone(rs.getString("phone"));
                dto.setSalary(rs.getDouble("salary"));

                // Устанавливаем имя позиции из результата запроса
                dto.setPositionName(rs.getString("position_name"));

                result.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
