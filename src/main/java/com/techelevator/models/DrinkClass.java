package com.techelevator.models;

public class DrinkClass extends ItemsForSale{
    public DrinkClass(String slot1, String itemName, double price, String type) {
        super(slot1, itemName, price, type);
    }

    @Override
    public String getSound() {
        return "Drinky, Drinky, Slurp Slurp!";
    }
}
