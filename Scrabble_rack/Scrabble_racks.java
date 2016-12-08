import java.util.*;
import java.lang.*;
import java.io.*;

public class Scrabble_racks {

	public static boolean CheckExist(List rack, List word) {
		List rack_copy = new ArrayList(rack);
		char b = '?';
		for (int i = 0; i < word.size(); i++) {
			if (rack_copy.contains(word.get(i)) || rack_copy.contains(b)) {
				for (int j = 0; j < rack_copy.size(); j++) {
					if (word.get(i) == rack_copy.get(j)) {
						rack_copy.remove(j);
						break;
					} else if (rack_copy.get(j).equals(b)) {
						rack_copy.remove(j);
						break;
					}
				}
			} else {
				return false;
			}
		}
		return true;
	}

	public static String Longest(List rack) {
		List<String> wordlist = new ArrayList<String>();
		try {
			Scanner input = new Scanner(new File("words.txt"));
			while (input.hasNextLine()) {
				wordlist.add(input.next());
			}
			input.close();
		} catch (FileNotFoundException ex) {
			return "Input file does not exist at this location.";
		}
		String temp = "temp";
		for (int i = 0; i < wordlist.size(); i++) {
			List current = new ArrayList();
			for (char c : wordlist.get(i).toCharArray()) {
				current.add(c);
			}
			if (CheckExist(rack, current) && wordlist.get(i).length() > temp.length()) {
				temp = wordlist.get(i);
			}
		}
		return temp;
	}

	public static void main(String args[]) {
		List rack = new ArrayList();
		List word = new ArrayList();

		System.out.println("Enter the tiles on the rack: ");
		Scanner in1 = new Scanner(System.in);
		String rack_input = in1.next();
		for (char c : rack_input.toCharArray()) {
			rack.add(c);
		}

		System.out.println("Enter the word you want to check: ");
		Scanner in2 = new Scanner(System.in);
		String word_input = in2.next();
		for (char c : word_input.toCharArray()) {
			word.add(c);
		}

		System.out.println("\n" + "Exists: " + CheckExist(rack, word));
		System.out.println("\n" + "Longest: " + Longest(rack));
	}
}

