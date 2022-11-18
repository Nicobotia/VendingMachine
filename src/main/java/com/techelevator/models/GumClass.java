package com.techelevator.models;

public class GumClass extends ItemsForSale{
    public GumClass(String slot1, String itemName, double price, String type) {
        super(slot1, itemName, price, type);
    }

    @Override
    public String getSound() {
        return "Chewy, Chewy, Lots O Bubbles!";
    }
}
