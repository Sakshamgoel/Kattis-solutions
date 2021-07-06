import java.util.*;
public class sumkindofproblem
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine());
		for(int i = 0; i < cases; i++)
		{
			int caseNo = in.nextInt();
			int number = in.nextInt();
			System.out.println(caseNo + " " + totalSum(number) + " " + oddSum(number) + " " + evenSum(number));
		}
	}
	public static int totalSum(int n)
	{
		if(n <= 0)
		{
			return 0;
		}
		int sum = 0;
		sum += n + totalSum(n-1);
		return sum;
	}
	public static int evenSum(int n)
	{
		int sum = 0;
		int j = 0;
		for(int i = 0; i < n; i++)
		{
			j += 2;
			sum += j;
			
		}
		return sum;
	}
	public static int oddSum(int n)
	{
		int sum = 1;
		int j = 1;
		for(int i = 1; i < n; i++)
		{
			j += 2;
			sum += j;
			
		}
		return sum;
	}
}
