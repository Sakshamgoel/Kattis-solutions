import java.util.*;
public class chanuka
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		int[] days = new int[cases];
		int[] candles = new int[cases];
		for(int i = 0; i < cases; i++)
		{
			int caseNo = in.nextInt();
			days[i] = in.nextInt();
		}
		for(int i = 0; i < cases; i++)
		{
			candles[i] = days[i] + chanuka.reSum(days[i]);
		}
		for(int i = 0; i < cases; i++)
		{
			System.out.print(i+1 + " ");
			System.out.println(candles[i]);
		}
	}
	public static int reSum(int n)
	{
		if(n == 0)
		{
			return 0;
		}
		int sum = 0;
		sum += n + reSum(n-1);
		return sum;
	}
}