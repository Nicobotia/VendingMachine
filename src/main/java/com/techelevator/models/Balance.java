package com.techelevator.models;

import java.math.BigDecimal;
import java.util.Scanner;
import com.techelevator.ui.UserInput;


public class Balance {
    private BigDecimal currentMoney;
    private BigDecimal stuffCost; //not used yet
    private BigDecimal itemCost; //not used yet

    public Balance(BigDecimal x) {
        this.currentMoney = x; //in order to create a balance object you have to input x which is the current balance
        this.currentMoney = this.currentMoney.setScale(2);
                                //Check vending machine class
    }

    public BigDecimal getCurrentMoney() { //return balance of money fed to machine
        return currentMoney;
    }

    public BigDecimal addMoney() {
        Scanner feedMoney = new Scanner(System.in);
        BigDecimal one = new BigDecimal(1);
        BigDecimal five = new BigDecimal(5); //creating these variables fixed the issue of not being able to add the user money. OKAY.
        BigDecimal ten = new BigDecimal(10);  //can we put this in private variables at the top? ASK IF THAT IS A GOOD IDEA MAYBE?
        BigDecimal twenty = new BigDecimal(20); //Talked to Kelvin, he said here are good.

        while (true){
            System.out.println("Please enter money (only $1, $5, $10 or $20 bills): ");
            System.out.println("When done entering money please type 'done'");
            String userInput = feedMoney.nextLine();
            if (userInput.equals("done")) {
                break;
            }
            BigDecimal money = new BigDecimal(userInput);

            if (money.compareTo(one) == 0 || money.compareTo(five) == 0 || money.compareTo(ten) == 0 || money.compareTo(twenty) == 0) { // if statement works
                currentMoney = currentMoney.add(money);
            } else {
                System.out.println("Error, incorrect bill amount");
            }
            System.out.println("Current balance: " + "$" + currentMoney);
        }
        return currentMoney;
    }



    public void currentMoneyMinusItemPrice() {
        //currentMoney = currentMoney.substract(itemprice); //to update after something is bought
    }
    //stuffBalance method to keep track of how to much the items chosen cost??
    public void stuffBalance() {
        //stuffCost = stuffCost.add(itemprice);
    }
    //or can we just use one method and substract from each other

}
