package com.techelevator.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class TransferFileToMapTest {

    @Test
    public void readItems() {
        TransferFileToMap test = new TransferFileToMap();
        CollectItems collectItems = test.readItems();
        Map<String, ItemsForSale> map = collectItems.getMap();
        ItemsForSale items = map.get("A1");
        Assert.assertEquals("U-Chews", items.getItemName());
        Assert.assertEquals( 1.65, 0.01, items.getPrice());
        Assert.assertEquals( "A1", items.getSlot());
        Assert.assertEquals( "Gum", items.getType());
        Assert.assertEquals(16, map.size());
    }
}
