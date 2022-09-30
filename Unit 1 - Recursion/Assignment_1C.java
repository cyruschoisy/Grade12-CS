// Name: Cyrus Choi
// Date: September 20, 2022
// Description: Part C of Java Review and Using System Methods, reads in a file, line by line, to see whether the String given is a palinedrome.
// 100 000 case string works.

import java.io.*;

public class Assignment_1C {
    public static void main(String[] args) {
        int num = 0;
        int far = 1;
        String testCases = "";
        String largestPalinedrome = "";

        int saveFar = 0;
        int right = 1;
        int left = 1;
        int start = 0;
        int width = 0;

        try {
            BufferedReader inFile = new BufferedReader(new FileReader("input.txt"));

            // Reads in each line as a test case - later portrayed in the output in console with the longest palindrome
            while ((testCases = inFile.readLine()) != null) {
                testCases = testCases.trim ();
                num = testCases.length();

                palinedromeCheck (testCases, num, right, left, saveFar, largestPalinedrome, start, width);
            }
            inFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Reading error");
        }
    }

    // Checks if the value entered is a palindrome
    public static void palinedromeCheck (String testCases, int num, int right, int left, int saveFar, String largestPalinedrome , int start, int width) throws StringIndexOutOfBoundsException {
        System.out.println("File input: ");
        System.out.println("\t" + testCases);

        System.out.println("\nScreen Output: ");
        System.out.println("\tFinding the largest palindrome");

        // Even length strings
        if (testCases.length () % 2 == 0) {
            for (int i = 0; i < num; i++) {
                for (int x = 1; x < testCases.length() - 1; x++) {
                    // If the case before and after the middle term, it will enter the loop and count as a palindrome.
                    while (testCases.charAt(x - left) == testCases.charAt(x + right)) {
                        right++;
                        left++;

                        // When the letters are no longer the same, breaks out of the program
                        if (testCases.charAt(x - left) != testCases.charAt(x + right)) {
                            if (saveFar < right) {
                                saveFar = right;
                                largestPalinedrome = testCases.substring(x - saveFar + 1, x + saveFar);
                                start = x - saveFar + 1;
                                width = (saveFar - 1) + saveFar + 1;
                            }

                            else if (saveFar < left) {
                                saveFar = left;
                                largestPalinedrome = testCases.substring(x - saveFar + 1, x + saveFar);
                                start = x - saveFar + 1;
                                width = (saveFar - 1) + saveFar + 1;
                            }

                            right = 1;
                            left = 1;
                            break;
                        }
                    }
                }
            }
        }

        // Odd length strings
        else {
            for (int i = 0; i < num; i++) {
                for (int x = 1; x < testCases.length() - 2; x++) {
                    // If the case before and after the middle term, it will enter the loop and count as a palindrome.
                    while (testCases.charAt(x - left) == testCases.charAt(x + right)) {
                        right++;
                        left++;

                        // When the letters are no longer the same, breaks out of the program
                        if (testCases.charAt(x - left) != testCases.charAt(x + right)) {
                            if (saveFar < right) {
                                saveFar = right;
                                largestPalinedrome = testCases.substring(x - saveFar + 1, x + saveFar);
                                start = x - saveFar + 1;
                                width = (saveFar - 1) + saveFar + 1;
                            }

                            else if (saveFar < left) {
                                saveFar = left;
                                largestPalinedrome = testCases.substring(x - saveFar + 1, x + saveFar);
                                start = x - saveFar + 1;
                                width = (saveFar - 1) + saveFar + 1;
                            }

                            right = 1;
                            left = 1;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println ("\tLargest palindrome: " + largestPalinedrome);
        System.out.println ("\tStarting position: " + start);
        System.out.println ("\tLength: " + width);
        System.out.println ("Program is complete\n");
    }
}
