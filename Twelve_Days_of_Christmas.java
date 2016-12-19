import java.util.*;
import java.lang.*;
import static java.util.Arrays.asList;

public class Twelve_Days_of_Christmas {

	public static void lyrics() {
		List<String> numbers = asList("first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth");
		List<String> gifts = asList("Drummers Drumming", "Pipers Piping", "Lords a Leaping", "Ladies Dancing",
									"Maids a Milking", "Swans a Swimming", "Geese a Laying", "Golden Rings",
									"Calling Birds", "French Hens", "Turtle Doves", "Partridge in a Pear Tree \n");
		List<String> nums = asList("twelve ", "eleven ", "ten ", "nine ", "eight ", "seven ", "six ", "five ", "four ", "three ", "two ", "one ");

		for (int i = 0; i < 12; i++) {
			String start = "On the " + numbers.get(i) + " day of Christmas \n my true love sent to me:";
			System.out.println(start);
			for (int j = 11 - i; j <= 11; j++) {
				if (j == 11 && i == 0) {
					System.out.println(nums.get(j) + gifts.get(j));
				} else if (j == 11) {
					System.out.println("and " + nums.get(j) + gifts.get(j));
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