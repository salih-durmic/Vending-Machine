package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
import com.techelevator.models.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.techelevator.ui.UserInput.itemAvailable;
import static com.techelevator.ui.UserInput.money;
import static com.techelevator.ui.UserOutput.displayItem;

public class VendingMachine 
{
    private Map<Item,Integer> productMap = new HashMap<>();
    public void run()
    {
        generateMap();
        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                displayItem(productMap);
            }
            else if(choice.equals("purchase"))
            {
                String choice2 = UserInput.getPurchaseScreen();
                Scanner scan = new Scanner(System.in);
                if(choice2.equals("addMoney")){
                    UserInput.addMoney();
                } if(choice2.equals("select")){
                    displayItem(productMap);
                    itemAvailable(productMap);
                    //if slot non exist reutnr to purchase
                    // if slot is empty return to purchase
                    // if slot is not empty and money requirement is met dispense and return message+ increment purchased items by 1
                    // subtract money + Perform BOGODF - buy one get second item one dollar off math
                    // add log to audit slot location and price change
                } else if (choice2.equals("returnMain")){
                    // return user money and update current money in machine to 0
                    // return to main menu
                    // reset price discount to 0
                    UserOutput.displayHomeScreen();
                    UserInput.getHomeScreenOption();
                }
            }
            else if(choice.equals("exit"))
            {
                UserOutput.displayMessage("Thank you for purchasing");
                break;
            }
        }
    }
    public void generateMap(){
        File inventory = new File("catering.csv");

        if(inventory.exists()==false){
            System.out.println("Not a File!");
        }
        try {
            Scanner scanFile = new Scanner(inventory);
            while(scanFile.hasNextLine()){
                String itemlist []= scanFile.nextLine().split(",");
                Item products = new Item(itemlist[0],itemlist[1],Double.parseDouble(itemlist[2]),itemlist[3]);
                productMap.put(products,6);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
