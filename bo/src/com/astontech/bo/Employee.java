package com.astontech.bo;

import java.util.Date;
import java.util.List;

public class Employee extends Person {

    //region PROPERTIES

    private int employeeId;
    private Date hireDate;
    private Date termDate;
    private String email;

    //endregion

    //region CONSTRUCTORS

    public Employee() {

    }

    public Employee(String firstName, String lastName) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
    }

    public Employee(int employeeId, Date hireDate, Date termDate, String email) {
        this.employeeId = employeeId;
        this.hireDate = hireDate;
        this.termDate = termDate;
        this.email = email;
    }

    //endregion

    //region GETTERS SETTERS

    public int getEmployeeId() {
       return this.employeeId;
    }

    public void setEmployeeId(int id) {
        this.employeeId = id;
    }

    public Date getHIreDate() {
        return this.hireDate;
    }

    public void setHireDate(Date date) {
        this.hireDate = date;
    }

    private Date getTermDate() {
        return this.termDate;
    }

    private void setTermDate(Date date) {
        this.termDate = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    //endregions

}
