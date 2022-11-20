package com.techelevator.models;

import com.techelevator.ui.UserInput;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransferFileToList {
    private List<ItemsForSale> listItems = new ArrayList<>();
    public List<ItemsForSale> readItems() {
        File cateringFile = new File("catering.csv");
        try(Scanner fileInput = new Scanner(cateringFile)) {
            while (fileInput.hasNextLine()) {
                String lineOfText = fileInput.nextLine();
                String[] lineOfTextArray = lineOfText.split(",");

                String slot = lineOfTextArray[0];
                String itemName = lineOfTextArray[1];
                String tempPrice = lineOfTextArray[2];
                BigDecimal price = new BigDecimal(tempPrice);
                String type = lineOfTextArray[3];

// ItemsForSale is abstract class and make subclasses (gum, candy, etc) extend + dispense sound
                //Create if classes
                // if () ==> if user input is candy class, display code from below
                if (type.equalsIgnoreCase("Candy")){
                    ItemsForSale values = new CandyClass (slot,itemName,price);
                    listItems.add(values);
                }
                else if(type.equalsIgnoreCase("Drink")) {
                    ItemsForSale values = new DrinkClass (slot,itemName,price);
                    listItems.add(values);
                }
                else if(type.equalsIgnoreCase("Gum")) {
                    ItemsForSale values = new GumClass (slot,itemName,price);
                    listItems.add(values);
                }
                else if(type.equalsIgnoreCase("Munchy")) {
                    ItemsForSale values = new MunchyClass (slot,itemName,price);
                    listItems.add(values);
                }
            }
        } catch(Exception e) {
            System.out.println("file not found" + cateringFile.getAbsolutePath());
        }
        return listItems;
    }
}
