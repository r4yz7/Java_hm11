package com.example.java_lr11;

public class Car {
    int id;
    String model;
    String manufacturer;
    double engineVolume;
    int yearProduction;
    String color;
    String carType;

    public Car(int id,String model, String manufacturer, double engineVolume, int yearProduction, String color, String carType) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.engineVolume = engineVolume;
        this.yearProduction = yearProduction;
        this.color = color;
        this.carType = carType;
    }

    public String getModel() {
        return model;
    }

    public int getId(){
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public int getYearProduction() {
        return yearProduction;
    }

    public String getColor() {
        return color;
    }

    public String getCarType() {
        return carType;
    }
}
