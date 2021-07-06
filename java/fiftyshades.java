import java.util.Scanner;

public class fiftyshades {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int cases = Integer.parseInt(in.nextLine());

		int score = 0;

		for(int i = 0; i < cases; i++) {

			String input = in.nextLine();

			if(contains(input)) score++;
		}

		if(score > 0) {
			System.out.println(score);
		} else {
			System.out.println("I must watch Star Wars with my daughter");
		}
	}

	public static boolean contains(String inputIn) {
		String input = inputIn.toLowerCase();

		if(input.contains("rose") || input.contains("pink")) return true;

		return false;
	}
}