import java.util.*;
import java.lang.*;
import java.io.*;

/*
	highestScore finds the word in the wordlist that will give you the highest score for the tiles you have
	on the rack. Doesn't currenty include functionality for blank tiles.

	-Campbell
*/

public class highestScore {

	public static boolean checkExist(List rack, List word) {
		List rack_copy = new ArrayList(rack);
		for (int i = 0; i < word.size(); i++) {
			if (rack_copy.contains(word.get(i)) || rack_copy.contains('?')) {
				for (int j = 0; j < rack_copy.size(); j++) {
					if (word.get(i) == rack_copy.get(j)) {
						rack_copy.remove(j);
						break;
					} else if (rack_copy.get(j).equals('?')) {
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

	public static String wordScore(List rack) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
		int score = 0;

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
		String highestWord = "";
		for (int j = 0; j < wordlist.size(); j++) {
			List current = new ArrayList();
			for (char c : wordlist.get(j).toCharArray()) {
				current.add(c);
			}
			if (checkExist(rack, current)) {
				int tempscore = 0;
				for (int i = 0; i<current.size(); i++) {
					if (current.get(i).equals('?')) {
						tempscore += 0;
					} else {
						char c = (Character) current.get(i);
						tempscore += (i+1)*points[alphabet.indexOf(c)];
					}
				}
				if (tempscore > score ) {
					score = tempscore;
					highestWord = wordlist.get(j).toString();
				}
			}
		}
		return "Score: " + score + ", " + highestWord;
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

		System.out.println(wordScore(rack));
	}
}

