import java.util.*;
public class rationalsequence3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine());
		for(int j = 0; j < cases; j++) {
			String[] input = in.nextLine().split(" ");
			int caseNo = Integer.parseInt(input[0]);
			int num = Integer.parseInt(input[1]);
			StringBuilder sb = new StringBuilder();
			while(num != 1) {
				if(num % 2 == 0) sb.append('L');
				else sb.append('R');
				if(num >= 2) num = (int)(num / 2);
			}
			String path = sb.reverse().toString();
			//System.out.println(path);
			Point result = result(path);
			System.out.println(caseNo + " " + result.num + "/" + result.den);
		}
	}
	public static Point result(String path) {
		int num = 1;
		int den = 1;
		for(int i = 0; i < path.length(); i++) {
			if(path.charAt(i) == 'L') den += num;
			else num += den;
		}
		return new Point(num, den);
	}
}
class Point {
	int num;
	int den;
	public Point(int numIn, int denIn) {
		num = numIn;
		den = denIn;
	}
}