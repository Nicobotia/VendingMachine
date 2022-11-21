package com.techelevator.models;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditText {
    private String activity;
    private String slot;
    private BigDecimal deposit;
    private BigDecimal total;

    //new file object where is it supposed to go
    //idk how to create file
    //File auditFile = new File("Audit.txt");


    public AuditText(String activity, String slot, BigDecimal deposit, BigDecimal total) {
        this.activity = activity;
        this.slot = slot;
        this.deposit = deposit;
        this.total = total;
    }

    public String getAuditText() {
        timeDateStuff();
        //print to file here
        System.out.println(activity + "     " + slot + "        $" + deposit + "  $" + total + "\n");
        return (activity + "      " + slot + "   $" + deposit + "  $" + total + "\n");
    }


    public AuditText() throws FileNotFoundException {
        File auditFile = new File("C:\\Users\\Student\\workspace\\nicolas-botia-student-code\\java-orange-minicapstonemodule1-team2\\audit.txt");
        if (!auditFile.exists()) {
            try {
                auditFile.createNewFile();
            } catch (IOException e) {
                System.out.println("File not created");
            }
        }
        try (PrintWriter dataOutput = new PrintWriter(auditFile)) {
            dataOutput.println("Writing the first line of the file");
            dataOutput.println("Writing the second line of the file");
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open the file for writing.");
        }
    }




    //time and date stuff
    public void timeDateStuff() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("E MM/dd/yyyy hh:mm:ss a");
        String currentDateTime = dateTime.format(dateFormat);
        System.out.print(currentDateTime);
        System.out.print("      ");
    }


    

}
