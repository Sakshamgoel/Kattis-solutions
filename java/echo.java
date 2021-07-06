import java.util.Scanner;

public class echo {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		String input = in.nextLine();

		String output = "";

		for(int i = 0; i < 3; i++) {
			output += input + " ";
		}

		System.out.println(output.trim());
	}
}