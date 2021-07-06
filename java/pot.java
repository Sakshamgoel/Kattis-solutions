import java.util.Scanner;

public class pot {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		int cases = in.nextInt();

		int result = 0;

		for(int i = 1; i <= cases; i++) {

			int curr = in.nextInt();

			int power = curr % 10;
			curr = curr / 10;

			result += Math.pow(curr, power);
		}
		System.out.println(result);
	}
}