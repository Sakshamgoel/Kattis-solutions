import java.util.HashSet;
import java.util.Stack;
import java.util.Scanner;

public class queens {


	static int dim;

	static boolean[][] grid;

	static Stack<Point> stack;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		//dimensions of the board
		dim = in.nextInt();

		grid = new boolean[dim][dim];

		HashSet<Integer> rows = new HashSet<Integer>();
		HashSet<Integer> cols = new HashSet<Integer>();

		boolean correct = true;

		stack = new Stack<Point>();

		for(int i = 0; i < dim; i++) {
			int row = in.nextInt();
			int col = in.nextInt();

			if(rows.contains(row) || cols.contains(col)) {
				correct = false;
				break;
			} else {
				rows.add(row);
				cols.add(col);

				stack.push(new Point('b', row, col));

				grid[row][col] = true;

			}
			if(!correct) break;
		}

		correct = correct && DFS() && rows.size() == dim;

		if(correct) System.out.println("CORRECT");
		else System.out.println("INCORRECT");		
	}

	public static boolean DFS() {

		while(!stack.isEmpty()) {
			Point curr = stack.pop();

			int curRow = curr.r;
			int curCol = curr.c;
			char curDir = curr.dir;

			//upright
			if(curRow >= 1 && curCol < dim - 1 && (curDir == 'b' || curDir == 'e')) {
				if(grid[curRow - 1][curCol + 1]) {
					return false;
				}
				stack.push(new Point('e', curRow - 1, curCol + 1));
			}
			//upleft
			if(curRow >= 1 && curCol >= 1 && (curDir == 'b' || curDir == 'q')) {
				if(grid[curRow - 1][curCol - 1]) {
					return false;
				}
				stack.push(new Point('q', curRow - 1, curCol - 1));
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