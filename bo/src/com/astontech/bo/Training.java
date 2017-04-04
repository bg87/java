package com.astontech.bo;

public class Training extends BaseBO {

    //region PROPERTIES

    private int trainingId;
    private String name;

    //endregion

    //region CONSTRUCTORS

    public Training(int trainingId, String name) {
        this.trainingId = trainingId;
        this.name = name;
    }

    //endregion

    //region GETTERS SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    //endregion

    public void trainingInfo() {
        System.out.println(this.trainingId + ": " + this.name);
    }
}
