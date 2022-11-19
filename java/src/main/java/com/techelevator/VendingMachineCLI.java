package com.techelevator;

import com.techelevator.application.VendingMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static com.techelevator.ui.UserInput.*;

public class VendingMachineCLI 
{
    public static void main(String[] args) 
    {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.run();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);

        File dataFile = new File("Audit.txt");

        try(
                Scanner dataInput = new Scanner("Audit.txt");
                PrintWriter dataOutput = new PrintWriter(new FileOutputStream(dataFile, true)))

        {
            while (dataInput.hasNextLine()) {
                System.out.println("Hello");
                if (moneyUsed == true) {
                    dataOutput.println(formatDateTime + " MONEY FED: " + tempMoney + money);
                }

            }

        }catch(
                FileNotFoundException e)

        {
            System.err.println("Cannot open the file for writing.");
        }

    }
    
}
