import java.util.*;
public class rationalsequence2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine());
		for(int i = 0; i < cases; i++) {
			String input = in.nextLine();
			String[] Input = input.split(" ");
			int caseNo = Integer.parseInt(Input[0]);
			String[] theIn = Input[1].split("/");
			Point curr = new Point(Integer.parseInt(theIn[0]), Integer.parseInt(theIn[1]));
			String path = BFS(curr);
			int result = 1;
			for(int j = 0; j < path.length(); j++) {
				result *= 2;
				if(path.charAt(j) == 'R') result ++;
			}
			System.out.println(caseNo + " " + result);
		}
	}
	public static Point right(Point n) {
		return new Point(n.num - n.den, n.den);
	}
	public static Point left(Point n) {
		return new Point(n.num, n.den - n.num);
	}
	public static String BFS(Point n) {
		Point curr = new Point(1, 1);
		Point garbage = n;
		StringBuilder path = new StringBuilder();
		while(!curr.equals(garbage)) {
			if(garbage.den > garbage.num) {
				garbage = left(garbage);
				path.append('L');
			}
			else if(garbage.den < garbage.num) {
				garbage = right(garbage);
				path.append('R');
			}
		}
		return path.reverse().toString();
	}
}
class Point {
	int num;
	int den;
	public Point(int numIn, int denIn) {
		num = numIn;
		den = denIn;
	}
	public boolean equals(Point n) {
		return n.num == this.num && n.den == this.den;
	}
}
