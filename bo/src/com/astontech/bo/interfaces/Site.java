package com.astontech.bo.interfaces;

public class Site implements ILocation {

    private int confrenceRooms;
    private int offices;
    private int cubicles;
    private int trainingDesks;
    private int coffeeMachines;
    private String siteName;

    //region CONSTRUCTORS

    //endregion

    //region GETTERS SETTERS

    public int getConfrenceRooms() {
        return confrenceRooms;
    }

    public void setConfrenceRooms(int confrenceRooms) {
        this.confrenceRooms = confrenceRooms;
    }

    public int getOffices() {
        return offices;
    }

    public void setOffices(int offices) {
        this.offices = offices;
    }

    public int getCubicles() {
        return cubicles;
    }

    public void setCubicles(int cubicles) {
        this.cubicles = cubicles;
    }

    public int getTrainingDesks() {
        return trainingDesks;
    }

    public void setTrainingDesks(int trainingDesks) {
        this.trainingDesks = trainingDesks;
    }

    public int getCoffeeMachines() {
        return coffeeMachines;
    }

    public void setCoffeeMachines(int coffeeMachines) {
        this.coffeeMachines = coffeeMachines;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }


    //endregion

    @Override
    public int numberOfWorkspaces() {
        return (this.cubicles + this.offices + this.trainingDesks);
    };

    @Override
    public boolean canHoldMeetings() {
        if(this.confrenceRooms > 0) {
            return true;
        } else {
            return false;
        }
    };

    @Override
    public String getLocationName() {
        return siteName;
    };

    @Override
    public boolean hasCoffee() {
        if(this.coffeeMachines > 0) {
            return true;
        } else {
            return false;
        }
    };

}
