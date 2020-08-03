import java.util.*;
public class knightjump
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int size = Integer.parseInt(in.nextLine());
		int kAbs = 0;
		int kOrd = 0;
		boolean[][] board = new boolean[size][size];
		for(int i = 0; i < size; i++)
		{
			String input = in.nextLine();
			for(int j = 0; j < size; j++)
			{
				if(input.charAt(j) == '#')
				{
					board[i][j] = true;
				}
				if(input.charAt(j) == 'K')
				{
					kAbs = i;
					kOrd = j;
				}
			}
		}
		int moves = hops(board, size, kAbs, kOrd);
		System.out.println(moves);
	}
	public static int hops(boolean[][] board, int size, int kAbs, int kOrd)
	{
		boolean[][] visited = board;
		visited[kAbs][kOrd] = true;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {kAbs, kOrd, 0});
		while(!queue.isEmpty())
		{
			int[] curr = queue.poll();
			int curRow = curr[0];
			int curCol = curr[1];
			//reached (1,1)
			if(curRow == 0 && curCol == 0)
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
			if(curRow >= 2 && size - curCol > 1 && (!visited[curRow - 2][curCol + 1]))
			{
				queue.add(new int[] {curRow - 2, curCol + 1, curr[2] + 1});
				visited[curRow - 2][curCol + 1] = true;
			}
			//down right
			if(size - curRow > 2 && size - curCol > 1 && (!visited[curRow + 2][curCol + 1]))
			{
				queue.add(new int[] {curRow + 2, curCol + 1, curr[2] + 1});
				visited[curRow + 2][curCol + 1] = true;
			}
			//down left
			if(size - curRow > 2 && curCol >= 1 && (!visited[curRow + 2][curCol - 1]))
			{
				queue.add(new int[] {curRow + 2, curCol - 1, curr[2] + 1});
				visited[curRow + 2][curCol - 1] = true;
			}
			//right up
			if(curRow >= 1 && size - curCol > 2 && (!visited[curRow - 1][curCol + 2]))
			{
				queue.add(new int[] {curRow - 1, curCol + 2, curr[2] + 1});
				visited[curRow - 1][curCol + 2] = true;
			}
			//right down
			if(size - curRow > 1 && size - curCol > 2 && (!visited[curRow + 1][curCol + 2]))
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
			if(size - curRow > 1 && curCol >= 2 && (!visited[curRow + 1][curCol - 2]))
			{
				queue.add(new int[] {curRow + 1, curCol - 2, curr[2] + 1});
				visited[curRow + 1][curCol - 2] = true;
			}
		}
		return -1;
	}
}