package com.astontech.bo;

import java.util.ArrayList;

public class Email extends BaseBO {

    //region PROPERTIES

    private int emailId;
    private String emailAddress;
    private EntityType emailType;

    //endregion

    //region CONSTRUCTORS

    public Email() {
        this.emailType = new EntityType();
    }

    public Email(String emailAddress) {
        this.emailType = new EntityType();
        this.emailAddress = emailAddress;
    }

    //endregion

    //region GETTERS SETTERS

    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public EntityType getEmailType() {
        return emailType;
    }

    public void setEmailType(EntityType emailType) {
        this.emailType = emailType;
    }

    //endregion

}
