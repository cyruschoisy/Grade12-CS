// Name: Cyrus Choi
// Date: September 20, 2022
// Description: Part B of Java Review and Using System Methods, this program takes in an n'th digit number and the program finds the numbers between the highest and lowest value of given that is multiplied by 3

import java.util.*;

public class Assignment_1B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean isValidAmount;
        int n = 0;
        int multiplyNum = 0;
        String number = "";
        String multiplyNumber = "";
        int count = 0;

        do {
            try {
                System.out.print("n: ");
                n = Integer.parseInt(in.nextLine());
                isValidAmount = true;
            } catch (NumberFormatException e) {
                System.out.print("INVALID. Please enter a number: ");
                isValidAmount = false;
            }
        } while (isValidAmount != true);

//        Finds the largest n-digit number
        double largestNum = Math.pow(10, n) / 3;

//        Finds the smallest n-digit number
        int smallestNum = (int) (Math.pow(10, n - 1));

        // Cycles through the smallest and largest number
        for (int i = smallestNum; i < largestNum; i++) {
            multiplyNum = i * 3;

            number = Integer.toString(i);

            // Changing the integer to string so that substring works
            multiplyNumber = Integer.toString(multiplyNum);
            for (int x = 0; x < number.length(); x++) {
                int position = multiplyNumber.indexOf(number.charAt(x));
                // Checks if each number is in the program
                if (position == -1) {
                    break;
                }
                // At this point, the number has to be, so it is removed from the string
                multiplyNumber = multiplyNumber.substring(0, position) + multiplyNumber.substring(position + 1);
            }


            if (multiplyNumber.equals("")) {
                System.out.println(number + " " + (multiplyNum));
                count++;
            }
        }

        System.out.print (count);
    }
}
