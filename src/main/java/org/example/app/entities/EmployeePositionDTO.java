package org.example.app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class EmployeePositionDTO {
    private int id;
    private String lastName;
    private String firstName;
    private String birthDate;
    private int positionId;
    private String phone;
    private double salary;
    private String positionName; // Добавляем поле для имени позиции
}
