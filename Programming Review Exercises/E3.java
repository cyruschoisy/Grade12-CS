import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
        
        String word = "";

        word = in.nextLine();

        if (word.length () % 2 == 0) { // Even
            System.out.println("Even");
            
            for (int i = 0; i < word.length(); i=i+2) {
                System.out.print(word.charAt (i));
            }
        }

        else {
            System.out.println("Odd");
            
            for (int i = 1; i < word.length(); i=i+2) {
                System.out.print(word.charAt (i));
            }
        }
	in.close();
	}
}

