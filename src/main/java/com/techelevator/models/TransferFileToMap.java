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
                String temp = lineOfTextArray[2];
                Double price = Double.parseDouble(temp);
                String type = lineOfTextArray[3];

                ItemsForSale mapValue = new ItemsForSale(slot,itemName,price,type);
                mapItems.addItems(slot, mapValue);
            }

        } catch(Exception e) {
            System.out.println("file not found");
        }
        return mapItems;
    }
}
