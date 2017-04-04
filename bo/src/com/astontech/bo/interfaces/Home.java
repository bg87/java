package com.astontech.bo.interfaces;

import com.astontech.bo.Employee;

public class Home implements ILocation {

    private String address;
    private Employee owner;

    //region GETTERS SETTERS

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        owner = owner;
    }


    //endregion


    @Override
    public int numberOfWorkspaces() {
        return 1;
    }

    @Override
    public boolean canHoldMeetings() {
        return false;
    }

    @Override
    public String getLocationName() {
        return this.owner.getFirstName() + "'s house." ;
    }

    @Override
    public boolean hasCoffee() {
        return true;
    }
}
