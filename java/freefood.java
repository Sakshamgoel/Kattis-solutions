import java.util.Scanner;
import java.util.HashSet;

public class freefood {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		HashSet<Integer> days = new HashSet<Integer>();
		int events = in.nextInt();

		for(int i = 0; i < events; i++) {
			int start = in.nextInt();

			int end = in.nextInt();

			for(int j = start; j <= end; j++) {
				days.add(j);
			}
		}
		System.out.println(days.size());
	}
}