// Name: Cyrus Choi
// Date: September 20, 2022
// Description: Part A of Java Review and Using System Methods, this program allows the user to ask Ms. Wong if they would like to sell their Pokémon cards to Ms Wong
//              In the end, the program would print a receipt to see how much money Ms Wong owes to the user and how many cards the user still needs to sell elsewhere.

import java.io.*;
import java.util.*;
public class PartA {
    public static void main(String[] args) {
        boolean isValidAmount = false;
        double total = 0;

        int num = 1;
        String name = "";
        String type = "";
        double amount = 0;
        String more = "y";
        String buy;
        double maxPrice = 0;
        String maxName = "";
        int noBuy = 0;
        double noBuyPrice = 0;

        String[] categories = {"CARD", "TYPE", "COST"};
        String[] dashes = {"----", "----", "--------"};

        Scanner in = new Scanner(System.in);
        System.out.println("Bye Bye My Pokemon Cards\n");
        
        while (more.equalsIgnoreCase("y")) {
            // Name of card
            System.out.print("Please enter the name of card #" + num + ": ");
            name = in.nextLine();

            // Energy Type Input
            type = energy (type, in);

            // Cost Input
            amount = amount(amount, isValidAmount, in);

            if (amount >= maxPrice) {
                maxPrice = amount;
                maxName = name;
            }

            // Ms. Wong Purchase Decision
            System.out.printf("Will Ms. Wong buy this $%.2f card? (y/n) ", amount);
            buy = in.nextLine();

            while (!buy.equalsIgnoreCase("y") && !buy.equalsIgnoreCase("n") && !buy.equalsIgnoreCase(" ")) {
                System.out.printf("INVALID. Will Ms. Wong buy this $%.2f card? (y/n) ", amount);
                buy = in.nextLine();

                if (buy.equalsIgnoreCase("y") || buy.equalsIgnoreCase("n")) {
                    break;
                }
            }

            if (buy.equalsIgnoreCase("y")) {
                // Adds the total price
                total = total + amount;
            }

            if (buy.equalsIgnoreCase("n")) {
                noBuy++;
                noBuyPrice = amount;
            }

            // Selling more cards
            more = more(more, buy, in);

            header (name, type, amount, categories, dashes, num, buy);

            if (more.equalsIgnoreCase("n")) {
                System.out.println();
                break;
            } else if (more.equalsIgnoreCase("y")) {
                System.out.println();
                num++;
            }
        }

        fileWrite (total, noBuy, noBuyPrice, maxName, maxPrice, name, type, amount, categories, dashes);
        
    }
//    This method prints the name, amount and type of Pokémon card for each input, each time
//    If the program is on its first card, then it will also print the header of the receipt.
    public static void header (String name, String type, double amount, String [] categories, String [] dashes, int num, String buy) {
        try {
            PrintWriter outFile = new PrintWriter(new FileWriter("receipt.txt", true));
            if (num == 1) {
                outFile.printf("%-20s%-20s%-20s%n", categories[0], categories[1], categories[2]);
                outFile.printf("%-20s%-20s%-20s%n", dashes[0], dashes[1], dashes[2]);
            }

            if (buy.equals("y")) {
                outFile.printf("%-20s%-20s$%-30.2f%n", name, type, amount);
            }
            outFile.close();
        }

        catch (IOException e) {
            System.out.println("File error");
        }
    }

//    Writes the footer of the receipt, would append to the header and calculate the total, the highest price and
//    whether you need to sell the card elsewhere.
    public static void fileWrite (double total, int noBuy, double noBuyPrice, String maxName, double maxPrice, String name, String type, double amount, String [] categories, String [] dashes) {
        try {
            PrintWriter outFile = new PrintWriter(new FileWriter("receipt.txt", true));

            outFile.println("-----------------------------------------------------------------");
            outFile.printf("FINAL COST %37.2f$%n%n", total);
            outFile.printf("You still need to sell %d cards for $%.2f%n", noBuy, noBuyPrice);
            outFile.printf("The most expensive card you are selling is %s for $%.2f", maxName, maxPrice);
            outFile.close();
        }

        catch (IOException e) {
            System.out.println("File error");
        }
    }

    //  Asks the user how much they are selling the card for, and checks if the input is valid
    public static double amount (double amount, boolean isValidAmount, Scanner in) {
        do {
            try {
                System.out.print("Please enter the amount for this card: $");
                amount = Double.parseDouble(in.nextLine());

                while (amount < 0) {
                    System.out.print("INVALID. Please enter the amount for this card: $");
                    amount = Double.parseDouble(in.nextLine());
                }
                isValidAmount = true;
            } catch (NumberFormatException e) {
                System.out.print("INVALID. Please enter the amount for this card: $");
                isValidAmount = false;
            }
        } while (isValidAmount != true);
        
        return amount;
    }

    //    Reads in the energy type for the Pokémon as well as whether the input is valid or not.
    public static String energy (String type, Scanner in) {
        System.out.print("Please enter the energy type of this Pokemon: ");
        type = in.nextLine();

        while (!type.equalsIgnoreCase("grass") && !type.equalsIgnoreCase("fire") && !type.equalsIgnoreCase("water") && !type.equalsIgnoreCase("poison") && !type.equalsIgnoreCase("fairy") && !type.equalsIgnoreCase("psychic") && !type.equalsIgnoreCase("ghost") && !type.equalsIgnoreCase("dark") && !type.equalsIgnoreCase("other") && !type.equalsIgnoreCase(" ")) {
            System.out.print("INVALID. Please enter the energy type of this Pokemon: ");
            type = in.nextLine();

            if (type.equalsIgnoreCase("y") || type.equalsIgnoreCase("n")) {
                break;
            }
        }
        return type;
    }

    //    Asks the user if there are more cards + checks if the input is valid
    public static String more (String more, String buy, Scanner in) {
        System.out.print("Are you selling anymore cards? (y/n) ");
        more = in.nextLine();

        while (!more.equalsIgnoreCase("y") && !more.equalsIgnoreCase("n") && !more.equalsIgnoreCase(" ")) {
            System.out.print("INVALID. Are you selling anymore cards? (y/n) ");
            more = in.nextLine();

            if (more.equalsIgnoreCase("y") || buy.equalsIgnoreCase("n")) {
                break;
            }
        }
        return more;
    }
}
