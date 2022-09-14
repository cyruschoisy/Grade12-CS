import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Assignment_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        int num = 1;
        String [] name = new String [num];
        String [] type = new String [num];
        double [] amount = new double [num];
        String [] buy = new String [num];

        String more = "";
        
        System.out.println ("Bye Bye My Pokemon Cards\n");

        while (more != "n" || more != "N") {
            System.out.print ("Please enter the name of card #" + num + ": ");
            name [num-1]= in.nextLine (); 

            System.out.print ("Please enter the energy type for this card: ");
            type [num-1]= in.nextLine (); 

            System.out.print ("Please enter the amount for this card: $");
            amount [num-1] = in.nextDouble(); 

            System.out.print ("Will Ms. Wong buy this $" + amount [num-1] + " card? (y/n)");
            buy [num-1] = in.nextLine();
            
            System.out.print ("Are you selling anymore cards? (y/n)");
            more = String.parseString (in.nextLine());

            while (more != "n" || more != "N" || more != "Y" || more != "y") {
                System.out.print ("INVALID Are you selling anymore cards? (y/n)");
                more = in.nextLine();
            }
            System.out.println("");
            num++;
        }
    }
}
