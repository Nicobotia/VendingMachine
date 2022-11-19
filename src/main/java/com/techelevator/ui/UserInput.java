package com.techelevator.ui;

import com.techelevator.models.PurchaseMenu;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput
{
    private Scanner scanner = new Scanner(System.in);

    public String getHomeScreenOption()
    {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("D"))
        {
            return "display";
        }
        else if (option.equals("P"))
        {
          return "purchase";
        }
        else if (option.equals("E"))
        {
            return "exit";
        }

        else
        {
            return "";
        }


    }

    public String getPurchaseHomeOption (){
        BigDecimal x = new BigDecimal("0.00");
        System.out.println("M) Feed money");
        System.out.println("S) Select item");
        System.out.println("F) Finish transaction");
        System.out.println();
        System.out.println("Current Money Provided: " + "$" + x); //variable is in method
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();
        if (option.equals("M")){
            x.equals(feedMoney());
            System.out.println("Current money" + x);
            return "Feed money";
        }
        else if(option.equals("S")){
            System.out.println("here select item");
            return "Select item";
        }
        else if (option.equals("F")){
            System.out.println("here transaction");
            return "Finish transaction";
        }
        else {
            return "";
        }

}

    public BigDecimal feedMoney (){
        System.out.println("Please enter money (only $1, $5, $10 or $20 bills): ");
        Scanner feedMoney = new Scanner(System.in);
        BigDecimal money = feedMoney.nextBigDecimal();
        BigDecimal currentMoney = new BigDecimal("0.00");
        currentMoney = currentMoney.add(money);
       do {
           System.out.println("Please enter money (only $1, $5, $10 or $20 bills): ");
           System.out.println("When done entering money please type '0'"); //add money added for the first time
           money = feedMoney.nextBigDecimal();
           currentMoney = currentMoney.add(money);
           System.out.println("Money added " + "$" + currentMoney);
        } while (!money.equals(BigDecimal.ZERO));
        return currentMoney;
    }

    
}
