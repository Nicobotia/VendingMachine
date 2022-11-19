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

        String choice;
        do {
            userOutput.displayHomeScreen();
            choice = userInput.getHomeScreenOption();
            if(choice.equals("display")) {
                TransferFileToList list = new TransferFileToList();
                lisOfItems  = list.readItems();
                //add if product ran out of stock
                for (ItemsForSale item : lisOfItems){
                    System.out.println(item.getSlot() + " " + item.getItemName() + " " + "$" + item.getPrice() + " quantity left: " + item.getInStock());
                }
            }
            else if(choice.equals("purchase")) {
                System.out.println("here in purchase");   //so what happened is that we were returning purchase with a capital P in user input so it would exit us
                userInput.getPurchaseHomeOption();
                // we get display options now what?
                //maybe we send to a method outside so it doesnt get messy?
                //we could do the same with display
                //okay if m is returned this is where the money class comes in
            }
            else if (choice.equals("exit")) {
                System.out.println("here in exit");
                break; // might not need this?
            }
        } while(choice.equals("display"));
        /*
        while (!x.equals("exit")) {
            //userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();
            if (choice.equals("display")) {
                // display the vending machine slots
                TransferFileToList list = new TransferFileToList();
                lisOfItems  = list.readItems();
                //add if product ran out of stock
                for (ItemsForSale item : lisOfItems){
                    System.out.println(item.getSlot() + " " + item.getItemName() + " " + "$" + item.getPrice() + " quantity left: " + item.getInStock());
                }
                //userOutput.displayHomeScreen();
            } else if (choice.equals("purchase")) {
               choice = userInput.getPurchaseHomeOption();
                System.out.println("here part 2" + choice);
            } else if (choice.equals("exit")) {
                x = "exit"; // good bye+
            }
        }
         */
    }
}
