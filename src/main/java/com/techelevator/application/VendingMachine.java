package com.techelevator.application;

import com.techelevator.models.Balance;
import com.techelevator.models.ItemsForSale;
import com.techelevator.models.TransferFileToList;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.math.BigInteger;
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
                        if(itemAvailable && !money.equals(BigDecimal.ZERO)) {
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
        while(!change.equals(1)) {  //change to compare here
            change = change.subtract(BigDecimal.ONE); //figure out how to subtract change
        }
        System.out.println("after removing dollars " + change);
        //update balance to 0
    }

    public void callMenu(List<ItemsForSale> list1) {
        System.out.println();
        for (ItemsForSale item : list1){
            System.out.println(item.getSlot() + " " + item.getItemName() + " " + "$" + item.getPrice() + " Quantity Left: " + item.getInStock());
        }
        System.out.println();
    }


}
