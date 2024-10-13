package com.company.model;

import java.sql.Date;

public class Subject {
    private long id;
    private String name;
    private String description;
    private int credits;
    private String teacher;
    private Date startDate;
    private Date endDate;

    public Subject() {
    }

    public Subject(String name, String description, int credits, String teacher, Date startDate, Date endDate) {
        this.name = name;
        this.description = description;
        this.credits = credits;
        this.teacher = teacher;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Subject(long id, String name, String description, int credits, String teacher, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.credits = credits;
        this.teacher = teacher;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", credits=" + credits +
                ", teacher='" + teacher + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

