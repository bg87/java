package com.astontech.bo;

public class Phone extends BaseBO{

    //region PROPERTIES

    private int areaCode;
    private String phoneNumber;
    private EntityType phoneType;

    //endregion

    //region CONSTRUCTORS

    public Phone() {
        this.phoneType = new EntityType();
    }

    public Phone(int areaCode, String phoneNumber, EntityType phoneType) {
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
        this.phoneType = new EntityType();
    }

    //endregion

    //region GETTERS SETTERS

    public int getAreaCode(int anInt) {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public EntityType getPhoneType() {
        return phoneType;
    }

//    public void setPhoneType(String phoneType) {
//        this.phoneType = phoneType;
//    }


    //endregion
}
