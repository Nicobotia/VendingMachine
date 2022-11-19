package com.techelevator.models;

import com.techelevator.ui.UserInput;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransferFileToList {
    private List<ItemsForSale> listItems = new ArrayList<>();
    public List<ItemsForSale> readItems() {
        // read in file
        File cateringFile = new File("catering.csv");
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

// ItemsForSale is abstract class and make subclasses (gum, candy, etc) extend + dispense sound
                //Create if classes
                // if () ==> if user input is candy class, display code from below
                if (type.equalsIgnoreCase("Candy")){
                    ItemsForSale values = new CandyClass (slot,itemName,price);
                    listItems.add(values);
                }

            }
        } catch(Exception e) {
            System.out.println("file not found" + cateringFile.getAbsolutePath());
        }
        return listItems;
    }
}
