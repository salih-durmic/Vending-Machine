package com.techelevator.ui;

import com.techelevator.models.Item;

import java.math.BigDecimal;
import java.util.Map;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayItem(Map<Item,Integer> inputMap){
        {
            for(Map.Entry<Item, Integer> map : inputMap.entrySet()){
                System.out.println("Slot: "+map.getKey().getSlot()+" Name: "+map.getKey().getName()+" Price: $"+map.getKey().getPrice()
                        +" Quantity: "+map.getValue());
            }
        }
    }
}
