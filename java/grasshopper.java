import java.util.*;
public class grasshopper
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		while(in.hasNext())
		{
			int row = in.nextInt();
			int col = in.nextInt();
			int gAbs = in.nextInt();
			int gOrd = in.nextInt();
			int lAbs = in.nextInt();
			int lOrd = in.nextInt();
			int moves = hops(row, col, gAbs-1, gOrd-1, lAbs-1, lOrd-1);
			if(moves >= 0)
			{
				System.out.println(moves);
			}
			else
			{
				System.out.println("impossible");
			}
		}
	}
	public static int hops(int row, int col, int gAbs, int gOrd, int lAbs, int lOrd)
	{
		boolean[][] visited = new boolean[row][col];
		visited[gAbs][gOrd] = true;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {gAbs, gOrd, 0});
		while(!queue.isEmpty())
		{
			int[] curr = queue.poll();
			int curRow = curr[0];
			int curCol = curr[1];
			//reached leaf
			if(curRow == lAbs && curCol == lOrd)
			{
				return curr[2];
			}
			//up left
			if(curRow >= 2 && curCol >= 1 && (!visited[curRow - 2][curCol - 1]))
			{
				queue.add(new int[] {curRow - 2, curCol - 1, curr[2] + 1});
				visited[curRow - 2][curCol - 1] = true;
			}
			//up right
			if(curRow >= 2 && col - curCol > 1 && (!visited[curRow - 2][curCol + 1]))
			{
				queue.add(new int[] {curRow - 2, curCol + 1, curr[2] + 1});
				visited[curRow - 2][curCol + 1] = true;
			}
			//down right
			if(row - curRow > 2 && col - curCol > 1 && (!visited[curRow + 2][curCol + 1]))
			{
				queue.add(new int[] {curRow + 2, curCol + 1, curr[2] + 1});
				visited[curRow + 2][curCol + 1] = true;
			}
			//down left
			if(row - curRow > 2 && curCol >= 1 && (!visited[curRow + 2][curCol - 1]))
			{
				queue.add(new int[] {curRow + 2, curCol - 1, curr[2] + 1});
				visited[curRow + 2][curCol - 1] = true;
			}
			//right up
			if(curRow >= 1 && col - curCol > 2 && (!visited[curRow - 1][curCol + 2]))
			{
				queue.add(new int[] {curRow - 1, curCol + 2, curr[2] + 1});
				visited[curRow - 1][curCol + 2] = true;
			}
			//right down
			if(row - curRow > 1 && col - curCol > 2 && (!visited[curRow + 1][curCol + 2]))
			{
				queue.add(new int[] {curRow + 1, curCol + 2, curr[2] + 1});
				visited[curRow + 1][curCol + 2] = true;
			}
			//left up
			if(curRow >= 1 && curCol >= 2 && (!visited[curRow - 1][curCol - 2]))
			{
				queue.add(new int[] {curRow - 1, curCol - 2, curr[2] + 1});
				visited[curRow - 1][curCol - 2] = true;
			}
			//left down
			if(row - curRow > 1 && curCol >= 2 && (!visited[curRow + 1][curCol - 2]))
			{
				queue.add(new int[] {curRow + 1, curCol - 2, curr[2] + 1});
				visited[curRow + 1][curCol - 2] = true;
			}
		}
		return -1;
	}
}