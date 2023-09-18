package org.example.app.repositories.employees;

import org.example.app.database.DBConn;
import org.example.app.entities.Employee;
import org.example.app.utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeReadRepository {

    public List<Employee> readEmployees() {
        try (Statement stmt = DBConn.connect().createStatement()) {
            List<Employee> list = new ArrayList<>();
            String sql = "SELECT * FROM " + Constants.TABLE_EMPLOYEES;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new Employee(
                                rs.getInt("id"),
                                rs.getString("last_name"),
                                rs.getString("first_name"),
                                rs.getString("birth_date"),
                                rs.getInt("position_id"),
                                rs.getString("phone"),
                                rs.getDouble("salary")
                        )
                );
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
