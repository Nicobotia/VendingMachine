package com.techelevator.application;

import com.techelevator.models.CollectItems;
import com.techelevator.models.TransferFileToMap;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

public class VendingMachine 
{
    public void run()
    {
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();

        while(true)
        {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots
                TransferFileToMap map = new TransferFileToMap();
                CollectItems items = map.readItems();
                for(String key : items.getMap().keySet()){
                    System.out.println(key + " " + items.getMap().get(key).getItemName() + " " + "$" + items.getMap().get(key).getPrice());
                }


            }
            else if(choice.equals("purchase"))
            {
                // make a purchase
            }
            else if(choice.equals("exit"))
            {
                // good bye+

                break;
            }
        }
    }
    
}
