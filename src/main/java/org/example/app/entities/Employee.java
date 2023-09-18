package org.example.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    public Employee(int id, String lastName, String firstName, String birthDate, int positionId, String phone, double salary) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.positionId = positionId;
        this.phone = phone;
        this.salary = salary;
    }

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
}
