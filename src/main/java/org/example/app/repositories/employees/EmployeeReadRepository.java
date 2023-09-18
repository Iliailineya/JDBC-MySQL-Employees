package org.example.app.repositories.employees;

import org.example.app.database.DBConn;
import org.example.app.entities.Employee;
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
}
