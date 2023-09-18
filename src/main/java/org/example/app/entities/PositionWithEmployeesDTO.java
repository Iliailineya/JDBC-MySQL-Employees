package org.example.app.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class PositionWithEmployeesDTO {
    private int positionId;
    private String positionName;
    private List<Employee> employees;
}
