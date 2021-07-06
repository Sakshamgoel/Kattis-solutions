import java.util.Scanner;

public class logo {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int cases = Integer.parseInt(in.nextLine());

		for(int i = 0; i < cases; i++) {
			
			int moves = Integer.parseInt(in.nextLine());

			double endX = 0;
			double endY = 0;

			int currAngle = 0;

			for(int j = 0; j < moves; j++) {
				String[] input = in.nextLine().split(" ");

				String direction = input[0];
				int moveValue = Integer.parseInt(input[1]);

				switch(direction) {
					case "fd":
						endX += moveValue * Math.sin(Math.toRadians(currAngle));
						endY += moveValue * Math.cos(Math.toRadians(currAngle));
						break;
					case "bk":
						endX -= moveValue * Math.sin(Math.toRadians(currAngle));
						endY -= moveValue * Math.cos(Math.toRadians(currAngle));
						break;
					case "lt":
						currAngle -= moveValue;
						break;
					case "rt":
						currAngle += moveValue;
						break;
				}
			}

			System.out.println(Math.round(Math.sqrt(Math.pow(endX, 2) + Math.pow(endY, 2))));
		}
	}
}