import java.util.*;

public class Sept7 {   
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int counter = 0; 

        System.out.print ("Phrase: ");
        String word = in.nextLine();
        

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt (i) == 'e' || word.charAt (i) == 'E') {
                counter++;
            }
        }

        System.out.println(word.substring (1) + word.charAt (0));
        System.out.println(counter);

    }
}
