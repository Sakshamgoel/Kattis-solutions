import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.HashSet;
import java.util.Arrays;

public class kemija {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		String input = in.nextLine();

		StringBuilder sb = new StringBuilder();

		HashSet<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));




		for(int i = 0; i < input.length(); i++) {
			sb.append(input.charAt(i));
			if(vowels.contains(input.charAt(i))) {
				i = i + 2;
			}
		}
		System.out.println(sb.toString());
	}
}