import java.util.*;
import java.lang.*;
import static java.util.Arrays.asList;

public class Twelve_Days_of_Christmas {

	public static void lyrics() {
		List<String> numbers = asList("first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth");
		
		// Comment out this section and uncomment the next section to enable user input.
		///// COMMENT BEGINS /////
		List<String> gifts = asList("Drummers Drumming", "Pipers Piping", "Lords a Leaping", "Ladies Dancing",
									"Maids a Milking", "Swans a Swimming", "Geese a Laying", "Golden Rings",
									"Calling Birds", "French Hens", "Turtle Doves", "Partridge in a Pear Tree \n");
		///// COMMENT ENDS /////

		List<String> nums = asList("twelve ", "eleven ", "ten ", "nine ", "eight ", "seven ", "six ", "five ", "four ", "three ", "two ", "one ");

		// Comment out the following section and uncomment the above section to disable user input.
		///// COMMENT BEGINS /////
		// System.out.println("Please enter the number of different gifts: ");
		// Scanner in = new Scanner(System.in);
		// String[] input = new String[in.nextInt()];
		// in.nextLine();
		// System.out.println("Please enter the gifts, and after each one hit ENTER: ");

		// for (int n = 0; n < input.length; n++) {
		// 	input[n] = in.nextLine();
		// }

		// List<String> gifts = Arrays.asList(input);
		// Collections.reverse(gifts);
		///// COMMENT ENDS /////

		for (int i = 0; i < 12; i++) {
			String start = "\nOn the " + numbers.get(i) + " day of Christmas \nmy true love sent to me:";
			System.out.println(start);
			for (int j = 11 - i; j <= 11; j++) {
				if (j == 11 && i == 0) {
					System.out.println(nums.get(j) + gifts.get(j));
				} else if (j == 11) {
					System.out.println("and " + nums.get(j) + gifts.get(j) + "\n");
				} else {
					System.out.println(nums.get(j) + gifts.get(j));
				}
			}
		}
	}

	public static void main(String[] args) {
		lyrics();
	}
}