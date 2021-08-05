package com.search.app;

public class Guitar {
    String serialNumber;
    double price;
    String builder;
    String model;
    Type type;
    String backWood;
    String frontWood;

    public Guitar(String serialNumber, double price, String builder, String model, Type type, String backWood,
                  String frontWood){
        this.serialNumber = serialNumber;
        this.price = price;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.frontWood = frontWood;
        this.backWood = backWood;

    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getBackWood() {
        return backWood;
    }

    public void setBackWood(String backWood) {
        this.backWood = backWood;
    }

    public String getFrontWood() {
        return frontWood;
    }

    public void setFrontWood(String frontWood) {
        this.frontWood = frontWood;
    }
}
