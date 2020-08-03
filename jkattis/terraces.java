import java.util.*;
public class terraces
{
	static int[] parents;
	static int[] sizes;
	static int r,c;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		c = in.nextInt();
		r = in.nextInt();
		int[] grid = new int[c*r];
		parents = new int[c*r];
		sizes = new int[r*c];
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				grid[i*c + j] = in.nextInt();
				parents[i*c + j] = i*c + j;
				sizes[i*c + j] = 1;
			}
		}
		for(int i = 0; i < r*c; i++)
		{
			ArrayList<Integer> neigh = getneigh(i);
			for(int n : neigh)
			{
				if(grid[i] == grid[n])
				{
					union(i, n);
				}
			}
		}
		HashSet<Integer> parentSet = new HashSet<Integer>();
		for(int i = 0; i < r*c; i++)
		{
			parentSet.add(find(i));
		}

		for(int i = 0; i < r*c; i++)
		{
			ArrayList<Integer> neigh = getneigh(i);
			for(int n : neigh)
			{
				if(grid[i] > grid[n])
				{
					parentSet.remove(find(i));
				}
			}	
		}
		int total = 0;
		for(int goodParent : parentSet)
		{
			total += sizes[goodParent];
		}
		System.out.println(total);
	}
	static int find(int a)
	{
		int p_a = parents[a];
		if(p_a == a)
		{
			return a;
		}
		parents[a] = find(p_a);
		return parents[a];
	}
	static void union(int a, int b)
	{
		int p_a = find(a);
		int p_b = find(b);
		if(p_a < p_b)
		{
			parents[p_b] = p_a;
			sizes[p_a] += sizes[p_b];
		}
		if(p_a > p_b)
		{
			parents[p_a] = p_b;
			sizes[p_b] += sizes[p_a];
		}
	}
	static ArrayList<Integer> getneigh(int a)
	{
		ArrayList<Integer> valid = new ArrayList<Integer>();
		//left
		if(a-1 >= 0 &&  a/c == (a-1)/c)
		{
			valid.add(a-1);
		}
		//right
		if(a+1 < r*c && a/c == (a+1)/c)
		{
			valid.add(a+1);
		}
		//up
		if(a-c >= 0)
		{
			valid.add(a-c);
		}
		//down
		if(a+c < r*c)
		{
			valid.add(a+c);
		}
		return valid;
	}

}