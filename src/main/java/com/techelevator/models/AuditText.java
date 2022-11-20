package com.techelevator.models;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditText {

<<<<<<< HEAD
    //new file object where is it supposed to go
    //idk how to create file
    //File auditFile = new File("Audit.txt");



    public AuditText(){


       }
=======
    File auditFile = new File("audit.txt");


    public AuditText() throws FileNotFoundException {
        try (PrintWriter dataOutput = new PrintWriter(auditFile)) {
            dataOutput.println("Writing the first line of the file");
            dataOutput.println("Writing the second line of the file");
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open the file for writing.");
        }
    }
>>>>>>> 9c3b95e1e063e6c1c96078c9d2f55e031e3a2612



    //OR LIKE TRY TO FIND A MORE SIMPLE WAY
    //FOR FORMAT WE CAN USE MENU STUFF

    //time and date stuff
    public void timeDateStuff() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("E MM/dd/yyyy hh:mm:ss a");
        String currentDateTime = dateTime.format(dateFormat);
        System.out.print(currentDateTime);
        //PRINT TO TEXT FILE? WOULD IT STAY ON THE SAME LINE FOR THE OTHER METHODS
        System.out.println("  "); //2 spaces is enough space?
    }

    //NEXT THREE METHODS ARE GOING TO TAKE PARAMETERS DEPENDING ON WHAT NEEDS TO BE PRINTED
    //method to print to file when money is added
    //DONT ADD NEW LINES UNTIL THE VERY END SO IT IS IN A NEW LINE WHEN WE NEED TO PRINT TO TEXT FILE AGAIN
    public void deposit() {
        timeDateStuff();
        System.out.print("MONEY FED: ");
        //WE NEED TO FIX SPACING/FORMAT BECAUSE THE TEXT FILE NEEDS TO BE NEAT LIKE IN THE README
        //PARAMETERS MAYBE: MONEY INPUT EACH TIME
        //WE CAN HAVE A LOCAL VARIABLE START AT 0 AND THEN UPDATE WITH EACH MONEY INPUT PARAMETER?
        //PRINT TO TEXT FILE
    }

    //method to print when item chosen
    public void purchase() {
        timeDateStuff();
        //PARAMETER: TEST ITEM WE COPIED IN VENDING MACHINE
        //THEN EXTRACT ITEM NAME, ITEM SLOT, COST
        //ONE SIDE OF THE MONEY THING PRINTS THE BALANCE AND THE OTHER THE UPDATED BALANCE AFTER COST IS REMOVED
        //PRINT TO TEXT FILE AT END
    }

    //method to print when finish transaction
    public void transaction() {
        timeDateStuff();
        System.out.print("CHANGE GIVEN: ");
        //BASICALLY WE JUST CALL BALANCE AFTER FINISH TRANSACTION IS CHOSEN
        //AND THE OTHER LITTLE COLUMN WOULD BE 0 LIKE EVERY TIME
        //AND THEN PRINT TO TEXT FILE
    }
    

}
