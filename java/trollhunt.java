import java.util.Scanner;
import java.lang.Math;

public class trollhunt {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		double bridges = (double) in.nextInt() - 1;
		int knights = in.nextInt();
		int knightsPerGroup = in.nextInt();
		int groups = (int) knights / knightsPerGroup;
		int days = (int) Math.ceil(bridges / groups);
		System.out.println(days);
	}
}