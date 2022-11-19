package com.techelevator.application;

import com.techelevator.models.Balance;
import com.techelevator.models.ItemsForSale;
import com.techelevator.models.TransferFileToList;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
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
                //maybe we can menu print to its own method
                for (ItemsForSale item : lisOfItems){
                    System.out.print(item.getSlot() + " " + item.getItemName() + " " + "$" + item.getPrice() + " quantity left: " + item.getInStock());
                    //System.out.println("itemlength: " + item.getItemName().length());
                    //System.out.println(item.getSlot() + " " + item.getItemName() + " " + "$" + item.getPrice() + "       " + "Quantity Left: " + item.getInStock());
                }
            }
            else if(choice.equals("purchase")) {
                System.out.println("here in purchase");
                choice = userInput.getPurchaseHomeOption();
                if(choice.equals("Feed money")) {
                    //LINE 37: SAVES THE BALANCE FROM ADDMONEY() METHOD IN BALANCE CLASS TO VARIABLE X SO WE CAN SEND IT BACK TO BE SAVED IN MACHINE BALANCE
                    BigDecimal x = Balance.addMoney(); //static worked, now need to figure out how to add the money the user inputs
                    System.out.println("Current balance in purchase: $" + x);
                    //THIS IS WHERE WE send x to machineBalance
                    Balance moneyInMachine = new Balance(x); //THIS CREATES NEW BALANCE OBJECT WHICH WILL HOLD OUR BALANCE
                    System.out.println("balance class variable machineBalance says amount fed to machine: $" + moneyInMachine.getMachineBalance());
                    //SO IN PREVIOUS LINE 41 I CALLED THE MACHINE BALANCE AND IT GIVES ME THE SAME NUMBER THAT WE INPUT IN ADDMONEY METHOD
                }
                else if(choice.equals("Select item")) { //WE CAN START WORKING ON THIS!!! STEP 7 SELECTION S SELECT ITEM
                    //Bring up item menu?
                }
                else if(choice.equals("Finish transaction")) {
                    //payment and then send back to regular menu?
                }
            }
            else if (choice.equals("exit")) {
                System.out.println("here in exit");
                break;
            }
        } while(choice.equals("display"));
        /* //DONT DELETE THIS YET IN CASE WE NEED IT FOR THE TRUE CONDITION IDK HOW TO EXPLAIN
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
