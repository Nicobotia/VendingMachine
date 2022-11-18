package com.techelevator.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class TransferFileToMap{
    public TransferFileToMap() {
        Scanner scanner = new Scanner("catering.csv");
        // read in file
        File cateringFile = new File(scanner.nextLine());

        //split each line
        try(Scanner fileInput = new Scanner(cateringFile);) {
            while (fileInput.hasNextLine()) {
                String lineOfText = fileInput.nextLine();
                String[] lineOfTextArray = lineOfText.split(",");
                //loop adds stuff to map
                for(int i = 0; i < lineOfTextArray.length; i++) {
                    
                }
                /*
                for(Map.Entry<String,ItemsForSale> eachItem : ItemsForSale.entrySet()) {
                    //ItemsForSale.put(eachItem.getKey() + eachItem.getPrice().toString());
                    //ItemsForSale.setSlot(lineOfText[0]);
                }
                 */
            }

            // each word is an attribute of itemsForSale

            // Add each object to map
        } catch(Exception e) {
            System.out.println("file not found");
        }

    }
}
