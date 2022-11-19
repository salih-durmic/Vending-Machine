package com.techelevator.ui;

import com.techelevator.models.Item;
import com.techelevator.ui.UserInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static com.techelevator.ui.UserInput.*;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput {
    static File dataFile = new File("Audit.txt");

    public static void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayItem(Map<Item, Integer> inputMap) {
        {
            for (Map.Entry<Item, Integer> map : inputMap.entrySet()) {
                System.out.println("Slot: " + map.getKey().getSlot() + " Name: " + map.getKey().getName() + " Price: $" + map.getKey().getPrice()
                        + " Quantity: " + map.getValue());
            }
        }
    }

    public static String moneyReturn() {

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss a");
            String formatDateTime = now.format(format);

            UserOutput.printToAuditFile(formatDateTime + " CHANGE GIVEN: " + money + " 0.00");

        double hundred = 0;
        double fifty = 0;
        double twenty = 0;
        double ten = 0;
        double five = 0;
        double one = 0;
        double quarter = 0;
        double dime = 0;
        double nickel = 0;

        if ((money / 100) >= 1) {
            //250/100 = 2 hundred dollar bills
            hundred = (int) money / 100;
            //250/100=50
            money %= 100;
        }
        if ((money / 50) >= 1) {
            fifty = (int) money / 50;
            money %= 50;
        }
        if ((money / 20) >= 1) {
            twenty = (int) money / 20;
            money %= 20;
        }
        if ((money / 10) >= 1) {
            ten = (int) money / 10;
            money %= 10;
        }
        if ((money / 5) >= 1) {
            five = (int) money / 5;
            money %= 5;
        }
        if ((money / 1) >= 1) {
            one = (int) money / 1;
            money %= 1;
        }
        if ((money / .25) >= 1) {
            quarter = (int) (money / .25);
            money %= .25;
        }
        if ((money / .1) >= 1) {
            dime = (int) (money / .1);
            money %= .1;
        }
        if ((money / .05) >= 1) {
            nickel = (int) (money / .05);
            money %= .05;
        }
        money = 0;
        return "Your change is " + hundred + " hundred dollar bills, " + fifty + " fifty dollar bills, " + twenty + " twenty dollar bills, " + ten + " ten dollar bills, " + five + " five dollar bills, "
                + one + " one dollar bills, " + quarter + " quarters, " + dime + " dimes, and " + nickel + " nickels.";

    }

    public static void printToAuditFile(String auditLine) {

        try (PrintWriter dataOutput = new PrintWriter(new FileOutputStream(dataFile, true))) {

            dataOutput.println(auditLine);

        } catch (FileNotFoundException e) {
            System.err.println("Cannot open the file for writing.");
        }


    }
}

