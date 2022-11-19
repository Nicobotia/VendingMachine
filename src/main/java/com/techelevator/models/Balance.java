package com.techelevator.models;

import java.math.BigDecimal;
import java.util.Scanner;

public class Balance {
    private BigDecimal machineBalance;
    private BigDecimal stuffCost; //not used yet
    private BigDecimal itemCost; //not used yet

    public Balance(BigDecimal x) {
        this.machineBalance = x; //in order to create a balance object you have to input x which is the current balance
                                    //Check vending machine class
    }

    public BigDecimal getMachineBalance() { //return balance of money fed to machine
        return machineBalance;
    }

    public static BigDecimal addMoney() {
        Scanner feedMoney = new Scanner(System.in);
        BigDecimal currentMoney = new BigDecimal(0);
        BigDecimal one = new BigDecimal(1);
        BigDecimal five = new BigDecimal(5); //creating these variables fixed the issue of not being able to add the user money. OKAY.
        BigDecimal ten = new BigDecimal(10);  //can we put this in private variables at the top? ASK IF THAT IS A GOOD IDEA MAYBE?
        BigDecimal twenty = new BigDecimal(20);

        twoStrings(); //FOR NEATNESS PLEASE ENTER MONEY/TYPE 0 WHEN DONE LINES ADDED TO METHOD AT THE BOTTOM, FEEL FREE TO DELETE THIS COMMENT AFTER YOU READ
        BigDecimal money = feedMoney.nextBigDecimal();

        while(!money.equals(BigDecimal.ZERO)) {
            if (money.equals(one) || money.equals(five)|| money.equals(ten) || money.equals(twenty)) { // if statement works
                currentMoney = currentMoney.add(money);
                System.out.println("Current Money Provided: " + currentMoney);
            }
            else {
                while(!money.equals(one) || !money.equals(five)|| !money.equals(ten) || !money.equals(twenty)) {
                    System.out.println("Error, please enter money (only $1, $5, $10 or $20 bills): ");
                    System.out.println("When done entering money please type '0'");
                    money = feedMoney.nextBigDecimal();
                }
                currentMoney = currentMoney.add(money); //  I DIDNT TRY TO TYPE IN SOMETHING WRONG CUZ WHAT IF IT WENT WRONG AND ITS LIKE 11 FEEL FREE TO TRY
                System.out.println("Current Money Provided: " + currentMoney);
            }
            twoStrings();
            money = feedMoney.nextBigDecimal();
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




    public static void twoStrings() {
        System.out.println("Please enter money (only $1, $5, $10 or $20 bills): ");
        System.out.println("When done entering money please type '0'");
    }
}
