import java.util.Scanner;
public class conundrum
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		int days = 0;
		for(int i = 0; i < input.length(); i=i+3)
		{
			int j = 0;
			while(j <= 2)
			{
				if(j == 0 && !(input.charAt(i+j) == 'P'))
				{
					days++;
				}
				if(j == 1 && !(input.charAt(i+j) == 'E'))
				{
					days++;
				}
				if(j == 2 && !(input.charAt(i+j) == 'R'))
				{
					days++;
				}
				j++;
			}
		}
		System.out.println(days);
	}
}