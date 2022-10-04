// Cyrus Choi

import java.util.Scanner;

public class recursionExercises {
    // Question 1
    public static double sumReciprocal (int n) {
        // Base Case
        if (n == 1) {
            return n;
        }

        return 1.0 / n + sumReciprocal(n-1);
    }

    // Question 2
    public static int fib (int x) {
        // Base Case
        if (x <= 2) {
            return 1;
        }
        // Recursive Step
        return fib(x - 1) + fib (x - 2);
    }

    // Question 3
    public static int multiply (int y, int z) {
        int temp = 0;

        // Base Case
        if (y == 0) {
            return y;
        }

        if (z == 0) {
            return z;
        }

        if (y > 0 && z > 0) {
            return Math.abs(z) + multiply(Math.abs(y - 1), Math.abs(z));
        }

        else if (y < 0 && z < 0) {
            temp = Math.abs (z) + multiply (Math.abs (y + 1), Math.abs(z));
            return temp * -1;
        }

        else {
            temp = Math.abs (z) + multiply (Math.abs (y + 1), Math.abs(z));
            return temp * -1;
        }
    }

    // Question 4
    public static int findVowels (String s) {
        s = s.toUpperCase();
        int index = 0;
        int count = 0;

        // Base Case
        if (s.length() == 0) {
            return count;
        }

        if (s.charAt(index) == 'A' || s.charAt(index) == 'E' || s.charAt(index) == 'I' || s.charAt(index) == 'O' || s.charAt(index) == 'U') {
            count++;
        }

        // Recursive Step
        return count + findVowels(s.substring (1));
    }

    // Question 5
    public static String commas (int num) {
        // Base Case
        if (num / 1000 == 0) {
            if (num > 0) {
                return "+" + num;
            }

            else if (num == 0) {
                return "" + num;
            }
            return num + "";
        }

        // Recursive Step
        return commas (num / 1000) + "," + String.format ("%03d", Math.abs (num % 1000));
    }

    // Question 6
    public static String insert (String word, char c) {

        // Base Case
        if (word.length() < 2) {
            return word;
        }

        if ((word.charAt (0) + "").equalsIgnoreCase(word.charAt (1) + "")) {
            return word.substring (0, 1) + c + insert (word.substring (1), c);
        }

        if (Character.isLetter (word.charAt (0))) {
            return word.charAt (0) + insert (word.substring (1), c);
        }

        // Recursive Step
        return word.charAt (0) + insert (word.substring(1), c);
    }

    // Question 7
    public static int smallestNum (int [] numbers, int length) {
        int min;

        // Base Case
        if (length == 1) {
            min = numbers [0];
            return min;
        }

        // Recursive Step
        return Math.min (numbers[length-1], smallestNum(numbers, length-1));
    }


    public static void main (String[] args) {
        int [] numbers = {23, 5, -2, 2000, 234};
        int length = numbers.length;

        Scanner in = new Scanner(System.in);

//        Q1
        System.out.print ("Q1: ");
        int n = Integer.parseInt(in.nextLine());

        while (n <= 0) {
            System.out.print ("INVALID INPUT. TYPE AGAIN:");
            n = Integer.parseInt(in.nextLine());

            if (n > 0) {
                break;
            }
        }

        System.out.println (sumReciprocal(n));

//        Q2
        System.out.print ("Q2: ");
        n = Integer.parseInt (in.nextLine());

        while (n <= 0) {
            System.out.print ("INVALID INPUT. TYPE AGAIN:");
            n = Integer.parseInt(in.nextLine());

            if (n > 0) {
                break;
            }
        }

        System.out.println (fib (n));

//        Q3
        System.out.println ("Q3: ");
        System.out.print ("x: ");
        int x = Integer.parseInt(in.nextLine());
        System.out.print ("y: ");
        int y = Integer.parseInt(in.nextLine());
        System.out.println (multiply(x,y));

//        Q4
        System.out.print ("Q4: ");
        String s = "";
        boolean isValid = false;

        do {
            try {
                s = in.nextLine();
                isValid = true;

            } catch (NumberFormatException e) {
                System.out.print("INVALID INPUT. TYPE AGAIN:");
                isValid = false;
            }
        } while (!isValid);

        System.out.println (findVowels(s));

        isValid = false;

//        Q5
        System.out.print ("Q5: ");
        System.out.print ("Number: ");
        do {
            try {
                n = Integer.parseInt (in.nextLine());
                isValid = true;

            } catch (NumberFormatException e) {
                System.out.print("INVALID INPUT. TYPE AGAIN:");
                isValid = false;
            }
        } while (!isValid);

        System.out.println (commas (n));

        isValid = false;

//        Q6
        System.out.print ("Q6: ");
        System.out.print ("String: ");
        do {
            try {
                s = in.nextLine();
                isValid = true;

            } catch (NumberFormatException e) {
                System.out.print("INVALID INPUT. TYPE AGAIN:");
                isValid = false;
            }
        } while (!isValid);

        isValid = false;

        System.out.print ("Character: ");
        char c = 0;

        do {
            try {
                c = in.nextLine().charAt (0);
                isValid = true;
            }

            catch (NumberFormatException e) {
                System.out.print("INVALID INPUT. TYPE AGAIN:");
                isValid = false;
            }
        } while (!isValid);

        System.out.println (insert(s, c));

//        Q7
        System.out.print ("Q7: ");
        System.out.println (smallestNum(numbers, length));
    }
}
