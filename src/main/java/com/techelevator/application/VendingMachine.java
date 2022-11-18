package com.techelevator.application;

import com.techelevator.models.ItemsForSale;
import com.techelevator.models.TransferFileToList;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.util.List;

public class VendingMachine {
    private List<ItemsForSale> lisOfItems;
    public void run() {
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();

        while (true) {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if (choice.equals("display")) {
                // display the vending machine slots
                TransferFileToList list = new TransferFileToList();
                lisOfItems  = list.readItems();
                //add if product ran out of stock
                for (ItemsForSale item : lisOfItems){
                    System.out.println(item.getSlot() + " " + item.getItemName() + " " + "$" + item.getPrice() + " quantity left: " + item.getInStock());
                }


            } else if (choice.equals("purchase")) {
               choice = userInput.getPurchaseHomeOption();
                System.out.println("here part 2" + choice);

            } else if (choice.equals("exit")) {
                // good bye+

                break;
            }
        }
    }

}
