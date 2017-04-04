package com.astontech.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import common.helpers.StringHelper;

public class Person extends BaseBO implements Serializable {

    //region PROPERTIES

    private int personId;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String displayFirstName;
    private String gender;
    private String SSN;
    private Date birthDate;
    private List<Email> emails = new ArrayList<>();

    //endregion

    //region CONSTRUCTORS

    public Person(){
        this.emails = new ArrayList<>();
    }

    public Person(int personId, String title, String firstName, String lastName, String displayFirstName, String gender) {
        this.personId = personId;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayFirstName = displayFirstName;
        this.gender = gender;
    }

    public Person(int personId, String title, String firstName, String lastName) {
        this.personId = personId;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //endregion

    //region GETTERS SETTERS


    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getPersonId() {
        return this.personId;
    }

    public void setPersonId(int id) {
        this.personId = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String name){
        this.lastName = name;
    }

    public void setDisplayFirstName(String name) {
        this.displayFirstName = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDisplayFirstName() {
        return displayFirstName;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    //endregion

    //region CUSTOM METHODS

    public String getFullName() {
        if(StringHelper.isNullOrEmpty(this.firstName) && StringHelper.isNullOrEmpty(this.lastName)) {
            return  "No name set";
        } else {
            if(StringHelper.isNullOrEmpty(this.firstName)) {
                return this.lastName;
            } else if(StringHelper.isNullOrEmpty(this.lastName)) {
                return this.firstName;
            } else {
                return this.firstName + " " + this.lastName;
            }
        }
    }

    //endregion

    public int compareTo(Object temp) {
        Person other = (Person) temp;

        if(this.gender == other.gender) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {

        return "PersonId=" + this.personId + " Full Name=" + this.getFullName() + " DOB=" + this.birthDate + " SSN=" + this.SSN;

    }

}
