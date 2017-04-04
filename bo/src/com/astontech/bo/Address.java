package com.astontech.bo;

public class Address extends BaseBO {

    //region PROPERTIES

    private String line1;
    private String line2;
    private String city;
    private String country;
    private int zip;

    //endregion

    //region CONSTRUCTORS

    public Address(String country) {
        this.country = country;
    }

    public Address(String line1, String line2, String city, String country, int zip) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.country = country;
        this.zip = zip;
    }

    public Address(String city, String country, int zip) {
        this.city = city;
        this.country = country;
        this.zip = zip;
    }

    //endregion

    //region GETTERS SETTERS

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    //endregion


}
