import java.util.*;

public class test2 {   
    public static void main(String[] args) {
        String firstStr = "There are many methods available to work with Strings";
        String secondStr ="You should understand how each of these methods works";
        String thirdStr = " Good Luck ";

        String newStr = secondStr.substring (0, 26) + firstStr.substring (46) + firstStr.substring (35, 40);
        System.out.print(secondStr.lastIndexOf ("ho"));
    }
}
