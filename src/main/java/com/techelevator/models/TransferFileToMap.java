package com.techelevator.models;

import java.io.File;
import java.util.Scanner;

public class TransferFileToMap{
    public CollectItems readItems() {
        CollectItems mapItems = new CollectItems();
        // read in file
        File cateringFile = new File("C:\\Users\\Student\\workspace\\nicolas-botia-student-code\\java-orange-minicapstonemodule1-team2\\src\\catering.csv");
        //split each line
        try(Scanner fileInput = new Scanner(cateringFile)) {
            while (fileInput.hasNextLine()) {
                String lineOfText = fileInput.nextLine();
                String[] lineOfTextArray = lineOfText.split(",");

                String slot = lineOfTextArray[0];
                String itemName = lineOfTextArray[1];
                String tempPrice = lineOfTextArray[2];
                Double price = Double.parseDouble(tempPrice);
                String type = lineOfTextArray[3];

<<<<<<< HEAD
                ItemsForSale stuff = new ItemsForSale(zero,one,two,three);
                CollectItems mapStuff = new CollectItems(zero, stuff);

                //for(int i = 0; i < lineOfTextArray.length; i++) {

                //}
                /*
                for(Map.Entry<String,ItemsForSale> eachItem : ItemsForSale.entrySet()) {
                    //ItemsForSale.put(eachItem.getKey() + eachItem.getPrice().toString());
                    //ItemsForSale.setSlot(lineOfText[0]);
                }
                 */
=======
                ItemsForSale mapValue = new ItemsForSale(slot,itemName,price,type);
                mapItems.addItems(slot, mapValue);
>>>>>>> 83ca1d6dd2491ed1c523ca781e01478baf4345e6
            }

        } catch(Exception e) {
            System.out.println("file not found" + cateringFile.getAbsolutePath());
        }
        return mapItems;
    }
}
