package com.techelevator.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TransferFileToMapTest {

    @Test
    public void readItems() {
        TransferFileToList test = new TransferFileToList();
        List<ItemsForSale> collectItems = test.readItems();
        ItemsForSale items = null;
        for (ItemsForSale item : collectItems){
            if (item.getSlot().equals("A1")) {
                items = item;
            }
        }

        Assert.assertEquals("U-Chews", items.getItemName());
        Assert.assertEquals( 1.65, 0.01, items.getPrice());
        Assert.assertEquals( "A1", items.getSlot());
        Assert.assertEquals( "Gum", items.getType());
        Assert.assertEquals(16, collectItems.size());
    }
}
