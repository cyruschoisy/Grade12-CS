import java.io.*;
import java.util.*;

public class Assignment_1A {
	public static int num = 1;
    public static String name = "";
    public static String type = "";
    
	public static void main(String[] args) {
        boolean isValidAmount;
        double total = 0;
        int toSell = 0;
        double toSellPrice = 0; 
        
        int num = 1;
        String name = "";
        String type = "";
        double amount = 0;
        String more = "y";
        String buy = "y";
        double maxPrice = 0; 
        
        String [] categories = {"CARD", "TYPE", "COST"};
        String [] dashes = {"----", "----", "--------"};
        
        Scanner in = new Scanner (System.in);        
        System.out.println ("Bye Bye My Pokemon Cards\n");

        
        while (more.equalsIgnoreCase ("y")) {
        	// Name of card
        	System.out.print ("Please enter the name of card #" + num + ": ");
        	name = in.nextLine ();
            
	        do {
	        	
	        	try {
			        System.out.print ("Please enter the amount for this card: $");
			        amount = Double.parseDouble(in.nextLine());
			        
			        while (amount < 0) {
			        	System.out.print ("INVALID. Please enter the amount for this card: $");
			            amount = Double.parseDouble(in.nextLine()); 
			        }
			        isValidAmount = true;
	        	}
	        	
	        	catch (NumberFormatException e) {
	        		System.out.print ("INVALID. Please enter the amount for this card: $");
		            isValidAmount = false;
	        	}
	        } while (isValidAmount != true);
	        
	        if (amount >= maxPrice) {
	        	maxPrice = amount; 
	        }
	        
	        total = total + amount; 

	        // Energy Type Input
	        System.out.print ("Please enter the energy type of this Pokemon: ");
	        type = in.nextLine (); 
	        
	        while (!type.equalsIgnoreCase("grass") && !type.equalsIgnoreCase("fire") && !type.equalsIgnoreCase("poison") && !type.equalsIgnoreCase("fairy") && !type.equalsIgnoreCase("psychic") && !type.equalsIgnoreCase("ghost") && !type.equalsIgnoreCase("dark") && !type.equalsIgnoreCase("other") && !type.equalsIgnoreCase(" ")) {
	        	System.out.print ("INVALID. Please enter the energy type of this Pokemon: ");
	        	type = in.nextLine();
	        	
	        	if (type.equalsIgnoreCase("y") || type.equalsIgnoreCase("n")) {
	        		break;
	        	}
	        }
	        
	        // Ms. Wong Purchase Decision
	    	System.out.printf ("Will Ms. Wong buy this $%.2f card? (y/n) ", amount);
	    	buy = in.nextLine();
	    	
	    	while (!buy.equalsIgnoreCase("y") && !buy.equalsIgnoreCase("n") && !buy.equalsIgnoreCase(" ")) {
	        	System.out.printf ("INVALID. Will Ms. Wong buy this $%.2f card? (y/n) ", amount);
	        	buy = in.nextLine();
	        	
	        	
	        	if (buy.equalsIgnoreCase("y") || buy.equalsIgnoreCase("n")) {
	        		break;
	        	}
	        }
	        
	    	// Selling more cards
	        System.out.print ("Are you selling anymore cards? (y/n) ");
	        more = in.nextLine();
	        
	        while (!more.equalsIgnoreCase("y") && !more.equalsIgnoreCase("n") && !more.equalsIgnoreCase(" ")) {
	        	System.out.print ("INVALID. Are you selling anymore cards? (y/n) ");
	        	more = in.nextLine();
	        	
	        	if (more.equalsIgnoreCase("y") || buy.equalsIgnoreCase("n")) {
	        		break;
	        	}
	        }
	       
	        if (more.equalsIgnoreCase("n")) {
	        	System.out.println();
	        	break;
	        }
	        
	        else if (more.equalsIgnoreCase("y")) {
	        	System.out.println();
	        	num++;
	        }
	        
	        try {
	        	PrintWriter outFile = new PrintWriter (new FileWriter ("output.txt", true));
	        	if (num == 2) {
	        		outFile.printf ("%-20s%-20s%-20s%n", categories [0], categories [1], categories [2]);
	        		outFile.printf ("%-20s%-20s%-20s%n", dashes [0], dashes [1], dashes[2]);
	        	}
	        	
	        	outFile.printf ("%-20s%-20s$%-19.2f%n", name, type, amount);
	        	outFile.println ("-----------------------------------------------------------------");
	        	outFile.printf ("FINAL COST %30.2f%n", total);
	        	outFile.close ();
	        }
	        
	        catch (IOException e ) {
	        	System.out.println("File error");
	        }
        }

        
        System.out.printf ("FINAL COST %30.2f%n", total);
        
        System.out.println ("You still need to sell " + toSell + " for " + toSellPrice + " .");
    }
}
