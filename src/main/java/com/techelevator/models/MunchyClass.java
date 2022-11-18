package com.techelevator.models;

public class MunchyClass extends ItemsForSale{


    public MunchyClass(String slot1, String itemName, double price, String type) {
        super(slot1, itemName, price, type);
    }

    @Override
    public String getSound() {
        return "Munchy, Munchy, so Good!";
    }
}
