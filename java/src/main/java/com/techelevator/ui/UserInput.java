package com.techelevator.ui;

import com.techelevator.models.Item;

import java.io.FileWriter;
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
    public static int counter = 0;
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
        System.out.println();
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
            if ( (input) == 1.0 ||  (input) == 5.0
                    ||  (input) == 10 ||  (input) == 20
                    ||  (input) == 50 ||  (input) == 100) {
                // Audit add previous moeny and new money (money +" "+money+input)
                money += input;
                System.out.println("updated money: $" + new BigDecimal(""+money));
                addMoney();
            }
        } catch (NumberFormatException | InputMismatchException e){
            System.out.println("Wrong input returning to purchase menu!");
            scanner.nextLine();
        }
    }

    public static void itemAvailable(Map<Item,Integer> inputMap){
        System.out.println("Select item");
        String userInput = scanner.nextLine();

        for(Map.Entry<Item, Integer> map : inputMap.entrySet()){
            try {
                if (userInput.equals(map.getKey().getSlot())) {
                    counter += 1;
                    System.out.println("Counter " + counter);
                    if (counter % 2 == 0) {
                        money++;
                    }
                    System.out.println("Item: " + map.getKey().getName());
                    System.out.println("Cost: " + map.getKey().getPrice());
                    System.out.println("Money Remaining: " + new BigDecimal("" + (money - map.getKey().getPrice())));
                    //Audit the slot Current money and previous money
                    money -= map.getKey().getPrice();
                    if (map.getKey().getType().equals("Munchy")) {
                        System.out.println("Munchy, Munchy, so Good!");
                    }
                    if (map.getKey().getType().equals("Candy")) {
                        System.out.println("Sugar, Sugar, so Sweet!");
                    }
                    if (map.getKey().getType().equals("Drink")) {
                        System.out.println("Drinky, Drinky, Slurp Slurp!");
                    }
                    if (map.getKey().getType().equals("Drink")) {
                        System.out.println("Chewy, Chewy, Lots O Bubbles!");
                    }
                } else if (map.getValue() == 0) {
                    System.out.println("NO LONGER AVAILABLE");
                    getPurchaseScreen();
                }
            }catch (Exception e){
                scanner.nextLine();
            }
        }
            System.out.println("This item doesn't exist");
            getPurchaseScreen();
            scanner.nextLine();
        }
    }


