package com.techelevator.models;

import java.util.HashMap;
import java.util.Map;

public class CollectItems<String> {
    private String mapSlot;
    private ItemsForSale otherStuff;

    Map<String, ItemsForSale> collectItemsMap = new HashMap<>();
    public CollectItems(String slot, ItemsForSale stuff) {
        this.mapSlot = slot;
        this.otherStuff = stuff;
        collectItemsMap.put(mapSlot,otherStuff);
    }


}
