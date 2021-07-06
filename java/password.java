import java.util.Scanner;
import java.util.Arrays;

public class password {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int passwords = Integer.parseInt(in.nextLine());

		double[] probabs = new double[passwords];

		for(int i = 0; i < passwords; i++) {
			String[] input = in.nextLine().split(" ");

			double probab = Double.parseDouble(input[1]);
			probabs[i] = probab;
		}

		Arrays.sort(probabs);

		double result = 0;

		int counter = 1;

		for(int i = probabs.length - 1; i >= 0; i--) {
			result += (probabs[i] * counter);
			counter++;
		}

		System.out.println(result);

		
	}
}