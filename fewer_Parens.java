import java.util.*;
import java.lang.*;
import java.io.*;

public class fewer_Parens {

	public static String reduce(String input) {
		StringBuilder str1 = new StringBuilder(input);
		int i = 0;
		while (i < str1.length()) {
			if (str1.charAt(i) == '(' && str1.charAt(i+1) == ')') {
				str1.deleteCharAt(i + 1);
				str1.deleteCharAt(i);
			} else {
				i++;
			}
		}

		int depth;
		for (int j = 0; j < str1.length() - 1; j++) {
			if (str1.charAt(j) == '(' && str1.charAt(j+1) == '(') {
				depth = 0;
				for (int k = j + 2; k < str1.length() - 1; k++) {
					if (str1.charAt(k) == ')' && str1.charAt(k+1) == ')' && depth == 0) {
						str1.deleteCharAt(k);
						str1.deleteCharAt(j);
						j--;
						break;
					}
					if (str1.charAt(k) == '(') {depth ++;}
					else if (str1.charAt(k) == ')') {depth --;}
					if (depth < 0) {break;}
				}
			}
		}

		return str1.toString();
	}

	public static void main(String[] args) {
		System.out.println("Enter line of text: ");
		Scanner in1 = new Scanner(System.in);
		String usr_input = in1.nextLine();

		System.out.println(reduce(usr_input));
	}
}