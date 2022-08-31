import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
        int total = 0;
        int num = 0; 
        int highest = 0; 

        for (int i = 0; i < 5; i++) {
            System.out.print ("Enter your num: ");
            num = in.nextInt();
            total = total + num;

            if (num >= highest) {
                highest = num; 
            }
        }

        System.out.println("The average is " + (total/5));
        System.out.println("The highest is " + highest);
	in.close();
	}
}

