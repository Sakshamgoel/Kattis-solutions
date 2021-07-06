import java.util.*;
public class lastfactorialdigit
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		int[] casea = new int[cases];
		for(int i = 0; i < cases; i++)
		{
			casea[i] = in.nextInt();
		}
		for(int i = 0; i < cases; i++)
		{
			System.out.println(finalVal(casea[i]));
		}
	}
	public static int fact(int n)
	{
		int factVal = 1;
		if(n <= 1)
		{
			return 1;
		}
		factVal = n * fact(n-1);
		return factVal;
	}
	public static int finalVal(int n)
	{
		int factorial = fact(n);
		return factorial % 10;
	}
}