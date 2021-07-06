import java.util.*;
public class bus
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for(int i = 0; i < cases; i++)
		{
			int stops = in.nextInt();
			int k = 1;
			for(int j = 0; j < stops-1; j++)
			{
				k = k*2 + 1;
			}
			System.out.println(k);
		}
	}
}