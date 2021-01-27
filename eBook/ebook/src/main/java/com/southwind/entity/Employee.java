package com.southwind.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {
    private String id;
    private Integer number;
    private Date acceptDate;
    private String title;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private long phone;
    private Date birthdate;
    private String nationality;
    private double salary;
    private String accounting;
    private String skill;
    private boolean admin;
    private boolean logged;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
