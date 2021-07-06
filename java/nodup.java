import java.util.*;
public class nodup
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String[] Input = input.split(" ");
		boolean found = false;
		for(int i = 0; i < Input.length; i++)
		{
			for(int j = 0; j < Input.length; j++)
			{
				if(i!=j && Input[i].equals(Input[j]))
				{
					found = true;
				}
			}
		}
		if(found)
		{
			System.out.println("no");
		}
		else
		{
			System.out.println("yes");
		}
	}
}