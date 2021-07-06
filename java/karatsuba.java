import java.util.Scanner;
import java.lang.Math;
public class karatsuba
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number 1: ");
		int num1 = in.nextInt();
		System.out.print("Enter number 2: ");
		int num2 = in.nextInt();
		int multi = realShit(num1, num2);
		System.out.println(multi);
	}
	public static int realShit(int int1,int int2)
	{
		int n = (int)(Math.log10(int1) + 1);
		if (n % 2 != 0)
		{
			n = n - 1;
		}
		int a = (int)(int1/Math.pow(10, n/2));
		int b = int1 - (int)(a * Math.pow(10, n/2));
		int c = (int)(int2/Math.pow(10, n/2));
		int d = int2 - (int)(c * Math.pow(10, n/2));
		int mult = 0;
		if (n > 4)
		{
			mult = (int)((realShit(a, c) * Math.pow(10, n)) + (Math.pow(10, n/2))*((realShit(a, d)) + (realShit(b, c)))
				+ (realShit(b, d)));
		}
		else
		{
			mult = (int)((a * c * Math.pow(10, n)) + (Math.pow(10, n/2))*((a * d) + (b * c)) + (b * d));
		}
		return mult;
	}
}