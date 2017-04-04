package com.astontech.bo;

import java.util.Date;

public class Vehicle extends BaseBO implements Comparable {

    //region PROPERTIES

    private int id;
    private int year;
    private String plate;
    private String vin;
    private String color;
    private boolean isPurchase;
    private long purchasePrice;
    private Date purchaseDate;
    private String make;
    private String model;

    //endregions

    //region CONSTRUCTORS

    public Vehicle() {}

    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public Vehicle(int id,
                   int year,
                   String plate,
                   String vin,
                   String color,
                   boolean isPurchase,
                   long purchasePrice,
                   Date purchaseDate,
                   String make,
                   String model) {
        this.id = id;
        this.year = year;
        this.plate = plate;
        this.vin = vin;
        this.color = color;
        this.isPurchase = isPurchase;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.make = make;
        this.model = model;
    }

    public Vehicle(long purchasePrice, Date purchaseDate, String make, String model) {
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.make = make;
        this.model = model;
    }

    //endregion

    //region GETTERS SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isPurchase() {
        return isPurchase;
    }

    public void setPurchase(boolean isPurchase) {
        this.isPurchase = isPurchase;
    }

    public long getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(long purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    //endregion

    public double salesTax(long price, double tax) {
        return price * tax;
    }

    public int compareTo(Object temp) {
        Vehicle other = (Vehicle) temp;

        if(this.year == other.year) {
            return 1;
        } else {
            return 0;
        }
    }
}
