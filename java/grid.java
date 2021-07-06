import java.util.*;
public class grid
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String rowIn = in.nextLine();
		String[] Input = rowIn.split(" ");
		int r = Integer.parseInt(Input[0]);
		int c = Integer.parseInt(Input[1]);
		int[][] theGrid = new int[r][c];
		for(int i = 0; i < r; i++)
		{
			String input = in.nextLine();
			for(int j = 0; j < c; j++)
			{
				theGrid[i][j] = input.charAt(j) - '0';
			}
		}
		System.out.println(BFS(theGrid, r, c));
	}
	public static int BFS(int[][] gridIn, int r, int c)
	{
		boolean[][] visited = new boolean[r][c];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add( new int[] {0,0,0});
		visited[0][0] = true;
		while(!queue.isEmpty())
		{
			int[] curr = queue.poll();
			int row = curr[0];
			int col = curr[1];
			//reached end
			if(r - row == 1 && c - col == 1)
			{
				return curr[2];
			}
			int jump = gridIn[row][col];
			//up
			if(row - jump >= 0 && !visited[row - jump][col])
			{
				queue.add(new int[] {row - jump, col, curr[2] + 1});
				visited[row - jump][col] = true;
			}
			//down
			if(row + jump < r && !visited[row + jump][col])
			{
				queue.add(new int[] {row + jump, col, curr[2] + 1});
				visited[row + jump][col] = true;
			}
			//left
			if(col - jump >= 0 && !visited[row][col - jump])
			{
				queue.add(new int[] {row, col - jump, curr[2] + 1});
				visited[row][col - jump] = true;
			}
			//right
			if(col + jump < c && !visited[row][col + jump])
			{
				queue.add(new int[] {row, col + jump, curr[2] + 1});
				visited[row][col + jump] = true;
			}
		}
		//no path found
		return -1;
	}
}