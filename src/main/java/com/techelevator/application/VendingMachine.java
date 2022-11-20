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
        BigDecimal x = new BigDecimal(BigInteger.ZERO);
        String slotChosen;
        TransferFileToList list = new TransferFileToList();
        lisOfItems  = list.readItems();
        do {
            System.out.println("back inside do while loop");
            userOutput.displayHomeScreen();
            choice = userInput.getHomeScreenOption();
            if(choice.equals("display")) {
                callMenu(lisOfItems);
            }
            else if(choice.equals("purchase")) {
                while(true) {
                    choice = userInput.getPurchaseHomeOption(x);
                    if (choice.equals("Feed money")) {
                        x = balance.addMoney();
                        System.out.println("Current balance in purchase: $" + x);
                        Balance moneyInMachine = new Balance(x);
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
                            System.out.println("Quantity Remaining: " + test.getInStock());
                        }
                        else { //slot exists checking availability
                            System.out.println("Slot identifier does not exist.");
                        }
                        if(!itemAvailable && slotExist) {
                            System.out.println("Item is out of stock.");
                        }
                        if(itemAvailable && slotExist && !x.equals(BigDecimal.ZERO)) {
                            //call balance method //ask about updating actual list item not the copy
                            int remaining = dispensing(test);
                            System.out.println("quantity after dispense " + remaining);
                            //call dispensing method
                        }
                        else {
                            if(x.equals(BigDecimal.ZERO)) {
                                System.out.println("Current balance is zero");
                            }
                        }
                    } else if (choice.equals("Finish transaction")) {

                        System.out.println("here in finish transaction");
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

    public BigDecimal updateBalance(ItemsForSale item, BigDecimal num) {
        BigDecimal moneyLeft = new BigDecimal(BigInteger.ZERO);
        moneyLeft = num.subtract(item.getPrice());
        return moneyLeft;
    }

    public int dispensing(ItemsForSale item) {
        System.out.println(item.getItemName() + " $" + item.getPrice() + " balance not here yet");
        //prints item sound
        int remaining = item.getInStock() - 1;
        return remaining;
    }


    public void callMenu(List<ItemsForSale> list1) {
        System.out.println();
        for (ItemsForSale item : list1){
            System.out.println(item.getSlot() + " " + item.getItemName() + " " + "$" + item.getPrice() + " Quantity Left: " + item.getInStock());
        }
        System.out.println();
    }


}
