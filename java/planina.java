import java.util.Scanner;

public class planina {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int points = 2;

		for(int i = 0; i < n; i++) {
			points += (points - 1);
		}

		System.out.println(points * points);
	}
}