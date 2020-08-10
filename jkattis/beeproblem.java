import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

public class beeproblem {

	//array to store which blocks are already filled or visited
	public static boolean[][] visited;

	//array to store union parents of each block
	//in the honeycomb
	public static int[][] parents;

	public static int row;
	public static int col;

	//linked list to store list of potential filling area
	public static Stack<Point> blocks;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		String[] input = in.nextLine().split(" ");

		int honey = Integer.parseInt(input[0]);
		row = Integer.parseInt(input[1]);
		col = Integer.parseInt(input[2]);

		visited = new boolean[row][col];
		parents = new int[row][col];
		blocks = new Stack<Point>();

		for(int i = 0; i < row; i++) {
			input = in.nextLine().trim().split(" ");
			for(int j = 0; j < input.length; j++) {
				if(input[j].charAt(0) == '#') {
					visited[i][j] = true;
				} else {
					blocks.push(new Point(i, j, -1));
				}
				parents[i][j] = -1;
			}
		}
		int lastParent = DFS();

		int[] sizeList = new int[lastParent + 1];

		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(parents[i][j] >= 0) {
					sizeList[parents[i][j]] += 1;
				}
			}
		}
		Arrays.sort(sizeList);

		int i = sizeList.length - 1;
		int steps = 0;
		while(honey > 0) {
			honey = honey - sizeList[i];
			i--;
			steps++;
		}

		System.out.println(steps);
	}

	public static int DFS() {
		int lastParent = 0;
		while(!blocks.isEmpty()) {
			Point curr = blocks.pop();
			int curRow = curr.r;
			int curCol = curr.c;
			if(parents[curRow][curCol] == -1) {
				curr.parent = lastParent;
				parents[curRow][curCol] = lastParent;
			}
			int curParent = curr.parent;

			//to remove points that are already unioned
			//but are still there in the stack
			if(visited[curRow][curCol]) continue;

			visited[curRow][curCol] = true;
			boolean deadEnd = true;

			//up
			if(curRow >= 1 && !visited[curRow - 1][curCol]) {
				blocks.push(new Point(curRow - 1, curCol, curParent));
				parents[curRow - 1][curCol] = curParent;
				deadEnd = false;
			}
			//down
			if(curRow < row - 1 && !visited[curRow + 1][curCol]) {
				blocks.push(new Point(curRow + 1, curCol, curParent));
				deadEnd = false;
				parents[curRow + 1][curCol] = curParent;
			}
			//left
			if(curCol >= 1 && !visited[curRow][curCol - 1]) {
				blocks.push(new Point(curRow, curCol - 1, curParent));
				deadEnd = false;
				parents[curRow][curCol - 1] = curParent;
			}
			//right
			if(curCol < col - 1 && !visited[curRow][curCol + 1]) {
				blocks.push(new Point(curRow, curCol + 1, curParent));
				deadEnd = false;
				parents[curRow][curCol + 1] = curParent;
			}
			//upright - only for odd number rows cause of honeycomb structure
			if(curRow >= 1 && curCol < col - 1 && !visited[curRow - 1][curCol + 1] && curRow % 2 != 0) {
				blocks.push(new Point(curRow - 1, curCol + 1, curParent));
				deadEnd = false;
				parents[curRow - 1][curCol + 1] = curParent;
			}
			//downright - only for odd number rows cause of honeycomb structure
			if(curRow < row - 1 && curCol < col - 1 && !visited[curRow + 1][curCol + 1] && curRow % 2 != 0) {
				blocks.push(new Point(curRow + 1, curCol + 1, curParent));
				deadEnd = false;
				parents[curRow + 1][curCol + 1] = curParent;
			}
			//upleft - only for even number rows cause of honeycomb structure
			if(curRow >= 1 && curCol >= 1 && !visited[curRow - 1][curCol - 1] && curRow % 2 == 0) {
				blocks.push(new Point(curRow - 1, curCol - 1, curParent));
				deadEnd = false;
				parents[curRow - 1][curCol - 1] = curParent;
			}
			//downleft - only for even number rows cause of honeycomb structure
			if(curRow < row - 1 && curCol >= 1 && !visited[curRow + 1][curCol - 1] && curRow % 2 == 0) {
				blocks.push(new Point(curRow + 1, curCol - 1, curParent));
				deadEnd = false;
				parents[curRow + 1][curCol - 1] = curParent;
			}



			if(deadEnd) {
				lastParent++;
			}

		}
		return lastParent;
	}

	static class Point {
		int r;
		int c;
		int parent;
		public Point(int rIn, int cIn, int parentIn) {
			r = rIn;
			c = cIn;
			parent = parentIn;
		}
	}
}