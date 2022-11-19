package com.techelevator.models;

public class CandyClass extends ItemsForSale {

    public CandyClass(String slot1, String itemName, double price) {
        super(slot1, itemName, price, "Candy");
    }

    @Override
    public String getSound() {
        return "Sugar, Sugar, so Sweet!";
    }
}
