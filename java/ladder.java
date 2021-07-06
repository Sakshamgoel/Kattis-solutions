import java.util.Scanner;

public class ladder {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int height = in.nextInt();
		double angle = Math.toRadians(in.nextInt());



		double ladderLength = (height / Math.sin(angle));

		int ladderL = (int)ladderLength;

		double decimal = ((ladderLength * 10) - (ladderL * 10)) / 10;

		if(decimal > 0) ladderL += 1;

		System.out.println(ladderL);
	}
}