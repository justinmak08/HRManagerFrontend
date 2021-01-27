package com.southwind.entity;
import lombok.Data;

@Data
public class Teams {
    private String id;
    private String name;
    private int manager;
    private int analyst;
    private int designer;
    private int programmer;
    private int tester;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
