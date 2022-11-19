package com.techelevator.models;

import java.math.BigDecimal;
import java.util.Scanner;

public class Balance {
    private BigDecimal currentMoney;
    private BigDecimal stuffCost;
    private BigDecimal itemCost;
    //do we need other variables

    public Balance() {
        this.currentMoney.equals(BigDecimal.ZERO);
    }
    public Balance(BigDecimal itemCost) {
        this.itemCost.equals(itemCost); //something wrong with this
    }


    public BigDecimal getCurrentMoney() {
        return currentMoney;
    }
    //METHOD TO ADD MONEY TO MACHINE
    //we can simplify this method but idk how to yet
    public void addMoney() {
        System.out.println("Please enter money (only $1, $5, $10 or $20 bills): ");
        Scanner feedMoney = new Scanner(System.in);
        BigDecimal money = feedMoney.nextBigDecimal();
        BigDecimal currentMoney = new BigDecimal("0.00");
        currentMoney = currentMoney.add(money); //do we need to add this. keyword???
        do {
            System.out.println("Please enter money (only $1, $5, $10 or $20 bills): ");
            System.out.println("When done entering money please type '0'"); //add money added for the first time
            money = feedMoney.nextBigDecimal();
            currentMoney = currentMoney.add(money);
            System.out.println("Current Money Provided: " + "$" + currentMoney);
        } while (!money.equals(BigDecimal.ZERO));
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
