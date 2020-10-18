import java.util.Scanner;
import java.util.Arrays;

public class commercials {

	static int[] items;

	static int students;
	
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
	
		students = in.nextInt();
		int price = in.nextInt();
	
		items = new int[students];
	
		for(int i = 0; i < students; i++) {
			items[i] = in.nextInt() - price;
		}

		System.out.println(dp());
	}

	//implements kadane's algorithm
	public static int dp() {

		int maxEndingHere = 0;
		int maxSoFar = 0;

		for(int i = 0; i < students; i++) {
			maxEndingHere += items[i];

			if(maxEndingHere > maxSoFar) maxSoFar = maxEndingHere;

			if(maxEndingHere < 0) maxEndingHere = 0;
			
		}

		return maxSoFar;
	}
}