package com.techelevator.ui;

import com.techelevator.models.Item;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput
{
    private static Scanner scanner = new Scanner(System.in);
    public static double money = 0;
    public static String getHomeScreenOption()
    {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("D"))
        {
            return "display";
        }
        else if (option.equals("P"))
        {
            return "purchase";
        }
        else if (option.equals("E"))
        {
            return "exit";
        }
        else
        {
            return "";
        }

    }

    public static String getPurchaseScreen()
    {
        System.out.println("(M) Feed Money");
        System.out.println("(S) Select Item");
        System.out.println("(F) Finish Transaction");
        System.out.println();
        System.out.println("Current Money Provided: $"+ new BigDecimal(""+money));

        System.out.print("Please select an option: ");
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();
        if (option.equals("M"))
        {
            return "addMoney";
        }
        else if (option.equals("S"))
        {
            return "select";
        }
        else if (option.equals("F"))
        {
            return "returnMain";
        }
        else
        {
            return "";
        }
    }

    public static void addMoney(){
        System.out.println("Please add bills(1,5,10,20,50,100)");
        System.out.println("Type any characters to Exit");
        try {
            int input = scanner.nextInt();
            System.out.println(input);
            while ((double) (input) == 1.0 || (double) (input) == 5.0
                    || (double) (input) == 10 || (double) (input) == 20
                    || (double) (input) == 50 || (double) (input) == 100) {
                money += (input);
                System.out.println("updated money: $" + new BigDecimal(""+money));

                addMoney();
                scanner.nextInt();
            }

            getPurchaseScreen();
        } catch (NumberFormatException | InputMismatchException e){
            getPurchaseScreen();
        }
    }

    public static void itemAvailable(Map<Item,Integer> inputMap){
        System.out.println("Select item");
        String userInput = scanner.nextLine();


        for(Map.Entry<Item, Integer> map : inputMap.entrySet()){
            int counter = 0;
            if(userInput.equals(map.getKey().getSlot())){
                    counter++;
                    if(counter%2 == 0) {
                        money++;
                    }
                    System.out.println("Item: " + map.getKey().getName());
                    System.out.println("Cost: " + map.getKey().getPrice());
                    System.out.println("Money Remaining: " + (money - map.getKey().getPrice()));
                    money -= map.getKey().getPrice();

                    if(map.getKey().getType() == "Munchy") {
                    System.out.println("Munchy, Munchy, so Good!");
                     }
                    if(map.getKey().getType() == "Candy") {
                    System.out.println("Sugar, Sugar, so Sweet!");
                    }
                    if(map.getKey().getType() == "Drink") {
                    System.out.println("Drinky, Drinky, Slurp Slurp!");
                    }
                    if(map.getKey().getType() == "Drink") {
                    System.out.println("Chewy, Chewy, Lots O Bubbles!");
                    }

                    scanner.nextLine();
                    getPurchaseScreen();
                }

             else if(map.getValue() == 0){
                    System.out.println("NO LONGER AVAILABLE");
                    scanner.nextLine();
                    getPurchaseScreen();

            }
        }
                System.out.println("This item doesn't exist");
                scanner.nextLine();
                getPurchaseScreen();
        }

    }


