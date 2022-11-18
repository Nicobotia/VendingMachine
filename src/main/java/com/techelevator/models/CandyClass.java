package com.techelevator.models;

public class CandyClass extends ItemsForSale {

    public CandyClass(String slot1, String itemName, double price, String type) {
        super(slot1, itemName, price, type);
    }

    @Override
    public String getSound() {
        return "Sugar, Sugar, so Sweet!";
    }
}
