package com.southwind.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Projects {
    private String id;
    private String name;
    private String language;
    private String team_id;
    private Date startDate;
    private Date dueDate;
    private Date creationDate;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
