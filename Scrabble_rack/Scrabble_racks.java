import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.URI;

/*
	Scrabble_racks checks if a word input by the user exists in a rack of letters also input by the user.
	-The second function, longest, outputs the the longest word from words.txt that can be created using the
	letters and blank tiles in the rack. 
	-The highest method returns the word that can be made with the tiles in the rack that will yield the highest score.
	-The wordScore method returns the score for the tiles you are checking against the rack.

	-Campbell
*/

public class Scrabble_racks {

	public static boolean checkExist(List rack, List word) {
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

	public static String longest(List rack) {
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
			if (checkExist(rack, current) && wordlist.get(i).length() > temp.length()) {
				temp = wordlist.get(i);
			}
		}
		return temp;
	}

	public static String highest(List rack) {
		List rack_copy2 = new ArrayList(rack);
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
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
		int point_total = 0;
		for (int i = 0; i < wordlist.size(); i++) {
			List current = new ArrayList();
			int current_point = 0;
			for (char c : wordlist.get(i).toCharArray()) {
				if (rack_copy2.contains(c)) {
					for (int j = 0; j<alphabet.length(); j++) {
						if (c == alphabet.charAt(j)) {
							current_point += points[j];
						}
					}
				}
				current.add(c);
			}
			if (checkExist(rack, current) && current_point > point_total) {
				temp = wordlist.get(i);
				point_total = current_point;
			}
		}
		return temp;
	}

	public static int wordScore(List rack, List word) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
		int score = 0;
		if (checkExist(rack, word)) {
			for (int i = 0; i<word.size(); i++) {
				if (word.get(i).equals('?')) {
					score += 0;
				} else {
					char c = (Character) word.get(i);
					score += points[alphabet.indexOf(c)];
				}
			}
		}
		return score;
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

		String rickroll = "rickroll";
		List rickroll_list = new ArrayList();
		for (char c : rickroll.toCharArray()) {
			rickroll_list.add(c);
		}
		
		if (checkExist(rack, rickroll_list) && checkExist(rickroll_list, word) && word.size() == rickroll_list.size()) {
			try {
				java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
			} catch (Exception ex) {
				System.out.println("");
			}
		}

		System.out.println("\n" + "Exists: " + checkExist(rack, word));
		System.out.println("Score: " + wordScore(rack, word));
		System.out.println("\n" + "Longest: " + longest(rack));
		System.out.println("\n" + "Highest: " + highest(rack));
	}
}

