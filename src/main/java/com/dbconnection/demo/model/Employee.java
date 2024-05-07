package com.dbconnection.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_tbl")
public class Employee {
    @Id
    private int id;
    private String name;
    private String address;
    private String email;
}
