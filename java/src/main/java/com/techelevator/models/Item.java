package com.techelevator.models;


public class Item {
    private String name, type, slot;
    private double price;
    public Item(String slot, String name, double price, String type){
        this.name=name;
        this.type=type;
        this.slot=slot;
        this.price=price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSlot() {
        return slot;
    }

    public double getPrice() {
        return price;
    }
}
