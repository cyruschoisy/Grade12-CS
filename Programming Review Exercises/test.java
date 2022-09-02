import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        for (char last = 'E'; last >= 'A'; last -= 2) { 
            for (char ch = 'A'; ch <= last; ch++) {
                System.out.print (ch); 
                System.out.println (); 
            }
        }
    }
}

