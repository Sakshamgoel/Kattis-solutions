import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;

public class hangman {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		String[] guessList = in.nextLine().split("");

		HashSet<String> guess = new HashSet<String>(Arrays.asList(guessList));

		String[] permutation = in.nextLine().split("");

		int hangCount = 0;

		for(int i = 0; i < permutation.length; i++) {
			if(guess.contains(permutation[i])) {
				guess.remove(permutation[i]);
			} else {
				hangCount++;
			}

			if(hangCount >= 10) break;
			if(guess.size() == 0) break;
		}
		boolean win = guess.size() == 0;
		if(win) {
			System.out.println("WIN");
		} else {
			System.out.println("LOSE");
		}

	}
}