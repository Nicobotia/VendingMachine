package com.techelevator.models;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ItemsForSale {
    private String slot;
    private String itemName;
    private double price;
    private String type;

    public ItemsForSale(String slot1, String itemName, double price, String type) {
        this.slot = slot1;
        this.itemName = itemName;
        this.price = price;
        this.type = type;
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

    //public void setSlot(String slot) {
    //    this.slot = slot;
    //}

}
