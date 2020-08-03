import java.util.*;
public class knightsearch {
	static String icpc = "ICPCASIASG";
	static int size;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		size = Integer.parseInt(in.nextLine());
		char[][] grid = new char[size][size];
		ArrayList<Point> iList = new ArrayList<Point>();
		String input = in.nextLine();
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				grid[i][j] = input.charAt(i*size + j);
				if(grid[i][j] == 'I') {
					Point p = new Point(i, j, 1);
					iList.add(p);
				}
			}
		}
		boolean possible = dfs(grid, iList);
		if(possible) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	public static boolean dfs(char[][] grid, ArrayList<Point> iList) {
		Stack<Point> stack = new Stack<Point>();
		for(Point p : iList) {
			stack.push(p);
			while(!stack.isEmpty()) {
				Point curr = stack.pop();
				int curRow = curr.r;
				int curCol = curr.c;
				int curScore = curr.score;
				if(curScore > 9) {
					return true;
				}
				//up left
				if(curRow >= 2 && curCol >= 1 && grid[curRow - 2][curCol - 1] == icpc.charAt(curScore)) {
					stack.push(new Point(curRow - 2, curCol - 1, curScore + 1));
				}
				//up right
				if(curRow >= 2 && size - curCol > 1 && grid[curRow - 2][curCol + 1] == icpc.charAt(curScore)) {
					stack.push(new Point(curRow - 2, curCol + 1, curScore + 1));
				}
				//down right
				if(size - curRow > 2 && size - curCol > 1 && grid[curRow + 2][curCol + 1] == icpc.charAt(curScore)) {
					stack.push(new Point(curRow + 2, curCol + 1, curScore + 1));
				}
				//down left
				if(size - curRow > 2 && curCol >= 1 && grid[curRow + 2][curCol - 1] == icpc.charAt(curScore)) {
					stack.push(new Point(curRow + 2, curCol - 1, curScore + 1));
				}
				//right up
				if(curRow >= 1 && size - curCol > 2 && grid[curRow - 1][curCol + 2] == icpc.charAt(curScore)) {
					stack.push(new Point(curRow - 1, curCol + 2, curScore + 1));
				}
				//right down
				if(size - curRow > 1 && size - curCol > 2 && grid[curRow + 1][curCol + 2] == icpc.charAt(curScore)) {
					stack.push(new Point(curRow + 1, curCol + 2, curScore + 1));
				}
				//left up
				if(curRow >= 1 && curCol >= 2 && grid[curRow - 1][curCol - 2] == icpc.charAt(curScore)) {
					stack.push(new Point(curRow - 1, curCol - 2, curScore + 1));
				}
				//left down
				if(size - curRow > 1 && curCol >= 2 && grid[curRow + 1][curCol - 2] == icpc.charAt(curScore)) {
					stack.push(new Point(curRow + 1, curCol - 2, curScore + 1));
				}
			}
		}
		return false;
	}
	static class Point {
		int r;
		int c;
		int score;
		public Point(int rIn, int cIn, int currIn) {
			this.r = rIn;
			this.c = cIn;
			score = currIn;
		}
	}
}