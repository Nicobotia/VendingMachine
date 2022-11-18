package com.techelevator.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TransferFileToMap {

    Scanner scanner = new Scanner("catering.csv");
    // read in file
    File cateringFile = new File(scanner.nextLine());

    //split each line
    try (Scanner fileInput = new Scanner(cateringFile)){
        while (fileInput.hasNextLine()){
            String lineOfText = fileInput.nextLine();
            String[] lineOfTextArray = lineOfText.split(",");

        }

        // each word is an attribute of itemsForSale

        // Add each object to map

    }
    catch (FileNotFoundException e){
        System.out.println("File was not found");
    }
}
