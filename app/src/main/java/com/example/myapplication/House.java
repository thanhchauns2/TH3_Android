package com.example.myapplication;

public class House {
    private long id;
    private double area;
    private double rentPrice;
    private double electricityPrice;
    private double waterPrice;
    private String areaCode;

    public House(long id, double area, double rentPrice, double electricityPrice, double waterPrice, String areaCode) {
        this.id = id;
        this.area = area;
        this.rentPrice = rentPrice;
        this.electricityPrice = electricityPrice;
        this.waterPrice = waterPrice;
        this.areaCode = areaCode;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public double getElectricityPrice() {
        return electricityPrice;
    }

    public void setElectricityPrice(double electricityPrice) {
        this.electricityPrice = electricityPrice;
    }

    public double getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(double waterPrice) {
        this.waterPrice = waterPrice;
    }

    public String getAreaCode() {
        return areaCode;
    }
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String toString() {
        return "House{" +
                "id=" + id +
                ", area=" + area +
                ", rentPrice=" + rentPrice +
                ", electricityPrice=" + electricityPrice +
                ", waterPrice=" + waterPrice +
                ", areaCode='" + areaCode + '\'' +
                '}';
    }
}
