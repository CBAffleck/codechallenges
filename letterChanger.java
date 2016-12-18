import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

/*
	letterChanger takes a user base input and final input and transforms the base into the final by randomly changing
	characters in the base input.

*/

public class letterChanger {

	public static String transform(String string1, String string2) {
		StringBuilder str1 = new StringBuilder(string1);
		StringBuilder str2 = new StringBuilder(string2);

		if (str1.length() > str2.length()) {
			while (str1.length() != str2.length()) {
				str2.append(" ");
			}
		} else if (str1.length() < str2.length()) {
			while (str1.length() != str2.length()) {
				str1.append(" ");
			}
		}
	
		Random rand = new Random();
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == str2.charAt(i)) {} else {
				for (int j = 0; j < 50; j++) {
					int next = rand.nextInt(str1.length());
					if (str1.charAt(next) != str2.charAt(next)) {
						str1.setCharAt(next, str2.charAt(next));
						System.out.println(str1);
					}
				}
			}
			
		}

		return str1.toString();
	}

	public static void main(String[] args) {
		System.out.println("Enter something to transform: ");
		Scanner in1 = new Scanner(System.in);
		String base = in1.nextLine();

		System.out.println("Enter desired result: ");
		Scanner in2 = new Scanner(System.in);
		String fin = in2.nextLine();

		System.out.println(transform(base, fin));
	}
}

