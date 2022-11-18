package com.techelevator.models;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public abstract class ItemsForSale {
    private String slot;
    private String itemName;
    private double price;
    private String type;
    private int inStock;

    public ItemsForSale(String slot1, String itemName, double price, String type) {
        this.slot = slot1;
        this.itemName = itemName;
        this.price = price;
        this.type = type;
        this.inStock = 6; //changed to = 6
        //do we need default stuff?????? naw
    }

    //i dont think we need the stuff below but just in case :3
    public String getSlot() {

        return slot;
    }
    public String getItemName(){

        return itemName;
    }
    public double getPrice() {

        return price;
    }
    public String getType() {

        return type;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String getSound(){

        return "";
    }


}
