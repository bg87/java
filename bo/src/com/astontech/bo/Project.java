package com.astontech.bo;

import java.util.Date;

public class Project extends BaseBO {

    //region PROPERTIES

    private int projectId;
    private Date startDate;
    private Date endDate;
    private String notes;
    private String name;
    private double rate;

    //endregion

    //region CONSTRUCTORS

    public Project(){}

    public Project(String name) {
        this.name = name;
    }

    public Project(int projectId, Date startDate, Date endDate, String notes, String name, double rate) {
        this.projectId = projectId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
        this.name = name;
        this.rate = rate;
    }

    public Project(Date startDate, Date endDate, String notes, String name, double rate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
        this.name = name;
        this.rate = rate;
    }

    //endregion

    //region GETTERS SETTERS

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    //endregions

    public String projectRate() {
        return this.name + ": " + this.rate;
    }
}
