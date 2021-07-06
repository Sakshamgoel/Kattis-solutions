import java.util.Scanner;

public class easiest {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		while(n != 0) {
			int nDigit = digits(n);

			int p = 11;

			while(digits(p*n) != nDigit) {
				p++;
			}
			System.out.println(p);

			n = in.nextInt();
		}
	}

	public static int digits(int n) {
		int sum = 0;

		while(n > 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}
}