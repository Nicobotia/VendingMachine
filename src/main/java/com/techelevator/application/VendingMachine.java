package com.techelevator.application;

import com.techelevator.models.AuditText;
import com.techelevator.models.Balance;
import com.techelevator.models.ItemsForSale;
import com.techelevator.models.TransferFileToList;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class VendingMachine {
    private List<ItemsForSale> lisOfItems;

    public void run() {
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();
        Balance balance = new Balance(BigDecimal.ZERO);

        String choice;
        BigDecimal money = new BigDecimal(BigInteger.ZERO);
        String slotChosen;

        TransferFileToList list = new TransferFileToList();
        lisOfItems  = list.readItems();
        Balance moneyInMachine = new Balance(money);
        AuditText depositMoney = new AuditText();
        do {
            System.out.println("back inside do while loop");
            userOutput.displayHomeScreen();
            choice = userInput.getHomeScreenOption();
            if(choice.equals("display")) {
                callMenu(lisOfItems);
            }
            else if(choice.equals("purchase")) {
                int count = 0;
                int temp = 0; //remaining quantity
                while(true) {
                    choice = userInput.getPurchaseHomeOption(money);
                    if (choice.equals("Feed money")) {
                        money = balance.addMoney();
                        System.out.println("Current balance in purchase: $" + money);
                        moneyInMachine.setCurrentMoney(money);
                        depositMoney.deposit();
                    } else if (choice.equals("Select item")) {
                        boolean slotExist = false;
                        boolean itemAvailable = false;
                        ItemsForSale test = new ItemsForSale("", "", BigDecimal.ZERO, "");
                        callMenu(lisOfItems);
                        slotChosen = UserInput.getSlotIdentifier();
                        for (ItemsForSale item : lisOfItems) {
                            if(slotChosen.equals(item.getSlot())) {
                                slotExist = true;
                                test = item;
                            }
                        }
                        if(slotExist) {
                            int quantityTest = test.getInStock();
                            if(quantityTest > 0) {
                                itemAvailable = true;
                            }
                        }
                        else { //slot exists checking availability
                            System.out.println("Slot identifier does not exist.");
                        }
                        if(!itemAvailable && slotExist) {
                            System.out.println("Item is out of stock.");
                        }
                        if(itemAvailable && money.compareTo(BigDecimal.ZERO) > 0) {
                            count++;
                            boolean thanksgiving = false;
                            if(count % 2 == 0) {
                                System.out.println("Discount: one dollar off");
                                thanksgiving = true;
                            }
                            //METHODS
                            BigDecimal remainingBalance = new BigDecimal(BigInteger.ZERO);
                            money = updateBalance(test, money); //balance part
                            moneyInMachine.setCurrentMoney(money); //update in balance class
                            temp = dispensing(test, money, thanksgiving);
                            test.setInStock(temp);
                        }
                        else {
                            if(money.equals(BigDecimal.ZERO)) {
                                System.out.println("Current balance is zero");
                            }
                        }
                    } else if (choice.equals("Finish transaction")) {
                        System.out.println("here in finish transaction");
                        //receive change
                        System.out.println("change to give back: " + moneyInMachine.getCurrentMoney());
                        change(moneyInMachine.getCurrentMoney());
                        //update balance to zero
                        break;
                    }
                }
            }
            else if (choice.equals("exit")) {
                System.out.println("here in exit");
                break;
            }
            System.out.println("right before while condition");
        } while(true);
        System.out.println("left do while loop");
    }

    public BigDecimal updateBalance(ItemsForSale item, BigDecimal balance) {
        BigDecimal moneyLeft = new BigDecimal(BigInteger.ZERO);
        moneyLeft = balance.subtract(item.getPrice());
        return moneyLeft;
    }
    public int dispensing(ItemsForSale item, BigDecimal remainingBalance, boolean tg) {
        System.out.println("DISPENSING");
        System.out.println("IN STOCK: " + item.getInStock());
        BigDecimal tempPrice = item.getPrice();
        if(tg) {
            tempPrice = tempPrice.subtract(BigDecimal.ONE);
        }
        System.out.println(item.getItemName() + " $" + tempPrice + " Remaining Balance: $" + remainingBalance);
        System.out.println(item.getSound());
        int remaining = item.getInStock() - 1;
        return remaining;
    }
    public void change(BigDecimal change) {
        System.out.println("initial change " + change);
        BigDecimal dollars = new BigDecimal("1");  //CAN WE MAKE ALL THESE DECIMALS PRIVATE OR SHOULD THEY STAY LOCAL?
        BigDecimal quarters = new BigDecimal("0.25");
        BigDecimal dimes = new BigDecimal("0.10");
        BigDecimal nickels = new BigDecimal("0.05");

        BigDecimal[] amount = new BigDecimal[4]; //here is where the amounts of each type of currency will go
        BigDecimal[] values = new BigDecimal[] {dollars, quarters, dimes, nickels};
        for(int i = 0; i < amount.length; i++) { //THERES SOMETHING WRONG IN HERE BECAUSE NICKELS GETS A REALLY CRAZY DECIMAL NUMBER
            amount[i] = change.divide(values[i], 0, RoundingMode.DOWN);
            change = change.setScale(2).remainder(values[i]);
        }
        System.out.println("dollars " + amount[0] + " quarters " + amount[1] + " dimes " + amount[2] + " nickels " + amount[3]);
        //UPDATE BALANCE TO 0
    }


    public void callMenu(List<ItemsForSale> list1) {
        System.out.println();
        int name = list1.get(0).getItemName().length();
        for(int i = 0; i < list1.size(); i++) {
            int temp = list1.get(i).getItemName().length();
            if(temp > name) {
                name = temp + 3;
            }
        }
        for (ItemsForSale item : list1){
            System.out.print(item.getSlot() + "   ");
            System.out.print(item.getItemName());
            //METHOD PRINTS SPACES
            for(int i = 0; i < name-item.getItemName().length(); i++) {
                System.out.print(" ");
            }
            System.out.println("$" + item.getPrice() + "   Quantity Left: " + item.getInStock());
        }
        System.out.println();
    }
}
