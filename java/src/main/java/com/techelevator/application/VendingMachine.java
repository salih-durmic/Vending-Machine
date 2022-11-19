package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
import com.techelevator.models.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.techelevator.ui.UserInput.*;
import static com.techelevator.ui.UserOutput.displayItem;
import static com.techelevator.ui.UserOutput.moneyReturn;

public class VendingMachine<formatDateTime> {

    private int level = 1;

    private Map<Item,Integer> productMap = new HashMap<>();
    public void run()
    {
        generateMap();
        while(level==1)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                displayItem(productMap);
            }
            else if(choice.equals("purchase"))
            {
                level=2;
                while(level==2){
                    String choice2 = UserInput.getPurchaseScreen();
                    Scanner scan = new Scanner(System.in);
                    if(choice2.equals("addMoney")){
                        UserInput.addMoney();
                    } if(choice2.equals("select")){
                        displayItem(productMap);
                        itemAvailable(productMap);

                    } else if (choice2.equals("returnMain")){
                        moneyReturn();
                        counter = 0;
                        level=1;
                    }
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
