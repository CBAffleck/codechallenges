import java.util.*;

public class Scrabble_racks {

	

	public static boolean CheckExist(List rack, List word) {
		for (int i = 0; i < word.size(); i++) {
			if (rack.contains(word.get(i))) {
				for (int j = 0; j < rack.size(); j++) {
					if (word.get(i) == rack.get(j)) {
						rack.remove(j);
						break;
					}
				}
			} else {
				return false;
			}
		}
		return true;
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

		System.out.println(CheckExist(rack, word));
	}
}