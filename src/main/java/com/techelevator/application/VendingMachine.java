package com.techelevator.application;

import com.techelevator.models.Balance;
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
                choice = userInput.getPurchaseHomeOption();
                if(choice.equals("Feed money")) {
                    //CALL BALANCE CLASS SOMEHOW????
                    Balance.addMoney(); //static worked, now need to figure out how to add the money the user inputs
                    //Balance.addMoney(); // this doesn't work beacuse static
                }
                else if(choice.equals("Select item")) {
                    //Bring up item menu?
                }
                else if(choice.equals("Finish transaction")) {
                    //payment and then send back to regular menu?
                }
            }
            else if (choice.equals("exit")) {
                System.out.println("here in exit");
                break; // might not need this?
            }
        } while(choice.equals("display"));
        /* //Dont delete this yet in case we need it again because of true condition
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
