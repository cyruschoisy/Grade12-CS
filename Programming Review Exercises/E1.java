import java.util.*;

public class E1 {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		
		double s1 = -1;
		double s2 = -1;

		while (s1 != 0 && s2 != 0) {
			System.out.println("Side 1 (a):");
			s1= in.nextDouble(); 

			System.out.println("Side 2 (b):");
			s2 = in.nextDouble(); 
		}

		System.out.println("The length of the hypotenuse is: " + Math.sqrt((Math.pow(s1, 2) + (Math.pow (s2,2) ))));
	in.close();
	}
}
