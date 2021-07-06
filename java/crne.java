import java.util.Scanner;

public class crne {
	
	public static void main(String[] args) {


		Scanner in = new Scanner(System.in);

		Long n = in.nextLong();

		Long result;

		if(n % 2 == 0) {
			Long z = (n / 2) + 1;
			//System.out.println("z = " + z);
			result = z * z;
		} else {
			result = (((n-1) / 2) + 1) * (((n + 1) / 2) + 1);
		}

		System.out.println(result);	
	}
}