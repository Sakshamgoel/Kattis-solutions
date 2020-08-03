import java.util.*;
public class coast {
	static int row;
	static int col;
	static int[][] grid;
	static boolean visited[][];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] input = in.nextLine().split(" ");
		row = Integer.parseInt(input[0]);
		col = Integer.parseInt(input[1]);
		grid = new int[row + 2][col + 2];
		visited = new boolean[row + 2][col + 2];
		for(int i = 1; i < row + 1; i++) {
			String rows = in.nextLine();
			for(int j = 1; j < col + 1; j++) {
				grid[i][j] = rows.charAt(j - 1) - '0';
				if(grid[i][j] == 1) {
					visited[i][j] = true;
				}
			}
		}
		int count = bfs(row + 2, col + 2);
		System.out.println(count);
	}
	static int bfs(int row, int col) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 0));
		visited[0][0] = true;
		int total = 0;
		while(!q.isEmpty()) {
			Point curr = q.poll();
			int curRow = curr.r;
			int curCol = curr.c;
			//down
			if(curRow + 1 < row && !visited[curRow + 1][curCol]) {	
				total += getNeigh(curRow + 1, curCol);
				q.add(new Point(curRow + 1, curCol));
				visited[curRow + 1][curCol] = true;
			}
			//up
			if(curRow - 1 >= 0 && !visited[curRow - 1][curCol]) {
				total += getNeigh(curRow - 1, curCol);
				q.add(new Point(curRow - 1, curCol));
				visited[curRow - 1][curCol] = true;
			}
			//right
			if(curCol + 1 < col && !visited[curRow][curCol + 1]) {
				total += getNeigh(curRow, curCol + 1);
				q.add(new Point(curRow, curCol + 1));
				visited[curRow][curCol + 1] = true;
			}
			//left
			if(curCol - 1 >= 0 && !visited[curRow][curCol - 1]) {
				total += getNeigh(curRow, curCol - 1);
				q.add(new Point(curRow, curCol - 1));
				visited[curRow][curCol - 1] = true;
			}
		}
		return total;
	}
	//gets the number of edges for each 0's
	static int getNeigh(int r, int c) {
		int borders = 0;
		//up
		if(r - 1 >= 0 && grid[r - 1][c] == 1) {
			borders++;
		}
		//down
		if(r + 1 <= row && grid[r + 1][c] == 1) {
			borders++;
		}
		//left
		if(c - 1 >= 0 && grid[r][c - 1] == 1) {
			borders++;
		}
		//right
		if(c + 1 <= col && grid[r][c + 1] == 1) {
			borders++;
		}
		return borders;
	}
		static class Point {
		int r = 0;
		int c = 0;
		Point(int r, int c)
		{
			this.r = r;
			this.c = c;
		}
	}
}