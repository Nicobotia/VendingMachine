package com.techelevator.models;

import java.util.HashMap;
import java.util.Map;

public class CollectItems {
    private String mapSlot;
    private ItemsForSale restOfItems;

    Map<String, ItemsForSale> collectItemsMap = new HashMap<>();

    public void addItems(String slot, ItemsForSale restOfItems) {
        this.mapSlot = slot;
        this.restOfItems = restOfItems;
        collectItemsMap.put(mapSlot, restOfItems);
    }

    public Map<String, ItemsForSale> getMap(){
        return collectItemsMap;
    }

}
