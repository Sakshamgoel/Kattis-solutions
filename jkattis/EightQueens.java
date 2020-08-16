import java.util.Scanner;
import java.util.HashSet;
import java.util.Stack;
import java.util.Arrays;

public class EightQueens {

	static Stack<Point> stack;
	static boolean[][] grid;

	static boolean valid;
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		HashSet<Integer> rows = new HashSet<Integer>();
		HashSet<Integer> cols = new HashSet<Integer>();

		grid = new boolean[8][8];

		stack = new Stack<Point>();

		valid = true;

		for(int i = 0; i < 8; i++) {
			String input = in.nextLine().trim();
			for(int j = 0; j < 8; j++) {
				if(input.charAt(j) == '*') {
					if(rows.contains(i) || cols.contains(j)) {
						valid = false;
						//System.out.println("false due to same row col");
						break;
					} else {
						rows.add(i);
						cols.add(j);
						stack.push(new Point('b', i, j));
						grid[i][j] = true;
					}
				} else {
					grid[i][j] = false;
				}
			}
			if(!valid) break;
		}
		
		valid = valid && DFS() && rows.size() == 8;

		if(valid) System.out.print("valid");
		else System.out.print("invalid");
	}

	public static boolean DFS() {
		while(!stack.isEmpty()) {
			Point curr = stack.pop();

			int curRow = curr.r;
			int curCol = curr.c;
			char curDir = curr.dir;

			//upright
			if(curRow >= 1 && curCol < 7 && (curDir == 'b' || curDir == 'e')) {
				if(grid[curRow - 1][curCol + 1]) {
					//System.out.println("queen " + (curRow - 1) + " " + (curCol + 1));
					return false;
				}
				stack.push(new Point('e', curRow - 1, curCol + 1));
				//System.out.println(curRow + " " + curCol + " " + curDir);
			}
			//upleft
			if(curRow >= 1 && curCol >= 1 && (curDir == 'b' || curDir == 'q')) {
				if(grid[curRow - 1][curCol - 1]) {
					//System.out.println("queen " + (curRow - 1) + " " + (curCol - 1));
					return false;
				}
				stack.push(new Point('q', curRow - 1, curCol - 1));
				//System.out.println(curRow + " " + curCol + " " + curDir);
			}

		}
		return true;
	}
		
}

class Point {
	char dir;
	int r;
	int c;

	public Point(char dirIn, int rIn, int cIn) {
		dir = dirIn;
		r = rIn;
		c = cIn;
	}
}