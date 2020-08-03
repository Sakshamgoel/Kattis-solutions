import java.util.*;
public class pieceofcake2
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		if(a <= (size/2))
		{
			a = size - a;
		}
		if(b <= (size/2))
		{
			b = size - b;
		}
		int vol = a * b * 4;
		System.out.println(vol);
	}
}