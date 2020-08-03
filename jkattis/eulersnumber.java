import java.util.*;
public class eulersnumber
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		double eulersNum = reSum(num) + 1;
		System.out.println(eulersNum);
	}
	public static double reSum(int n)
	{
		if(n <= 0)
		{
			return 0;
		}
		double sum = 0.0;
		sum += (1/reFactorial(n)) + reSum(n-1);
		return sum;
	}
	public static double reFactorial(int n)
	{
		if(n <= 1)
		{
			return 1;
		}
		double factorial = 1.0;
		factorial *= n * reFactorial(n-1);
		return factorial;
	}
}