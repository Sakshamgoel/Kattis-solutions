import java.util.Scanner;
import java.util.HashSet;
public class almostperfect {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		while(in.hasNext()) {
			int num = in.nextInt();
			System.out.print(num + " ");
			long sum = getFactors(num);
			//System.out.println(sum);
			if(sum == num) {
				System.out.println("perfect");
			} else if(Math.abs(sum - num) <= 2) {
				System.out.println("almost perfect");
			} else {
				System.out.println("not perfect");
			}
		}

	}

	public static long getFactors(int num) {
		int mid = (int) Math.sqrt(num) + 1;
		long sum = 1;
		for(int i = 2; i < mid; i++) {
			if(num % i == 0) {
				sum += i;
				int s = (int) num / i;
				//System.out.println(i);
				if(s != i) {
					sum += s;
					//System.out.println(s);
				}
			}
		}
		return sum;
	}
}