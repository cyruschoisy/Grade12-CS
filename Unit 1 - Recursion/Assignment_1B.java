import java.io.*;
import java.util.*;

public class Assignment_1B {
    public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		boolean isValidAmount; 
		
		String input = ""; 
		do {
        	
        	try {
        		System.out.print ("Number: ");
        		input = in.nextLine();
		        isValidAmount = true;
        	}
        	
        	catch (NumberFormatException e) {
        		System.out.print ("INVALID. Please enter a number: ");
	            isValidAmount = false;
        	}
        } while (isValidAmount != true);
		
		String [] numbers = new String [input.length()];
		
		for (int i = 0; i < input.length(); i++) {
			numbers [i] = input.charAt(i);
		}
	}
}
