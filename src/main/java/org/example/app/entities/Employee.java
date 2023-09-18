package org.example.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "position_id")
    private int positionId;

    @Column(name = "phone")
    private String phone;

    @Column(name = "salary")
    private double salary;

    public static Employee fromResultSet(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setLastName(rs.getString("last_name"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setBirthDate(rs.getString("birth_date"));
        employee.setPositionId(rs.getInt("position_id"));
        employee.setPhone(rs.getString("phone"));
        employee.setSalary(rs.getDouble("salary"));
        return employee;
    }
}
