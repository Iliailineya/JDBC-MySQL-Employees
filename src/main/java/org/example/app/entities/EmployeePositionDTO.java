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
public class EmployeePositionDTO {

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

    @Column(name = "position_Name")
    private String positionName; // Добавляем поле для имени позиции
}
