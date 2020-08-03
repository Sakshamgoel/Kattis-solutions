import java.util.Scanner;
import java.util.Arrays;
public class cetvrta
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int[] ab = new int[3];
		int[] ord = new int[3];
		for(int i = 0; i < 3; i++)
		{
			ab[i] = in.nextInt();
			ord[i] = in.nextInt();
		}
		Arrays.sort(ab);
		Arrays.sort(ord);
		int reqAb = 0;
		int reqOrd = 0;
		if(ab[0] == ab[1])
		{
			reqAb = ab[2];
		}
		else
		{
			reqAb = ab[0];
		}
		if(ord[0] == ord[1])
		{
			reqOrd = ord[2];
		}
		else
		{
			reqOrd = ord[0];
		}
		System.out.println(reqAb + " " + reqOrd);
	}
}