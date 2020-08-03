import java.util.Scanner;
import java.util.HashMap;
public class addingwords
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		HashMap<Integer, String> map2 = new HashMap<Integer, String>();
		String plus = "+";
		String minus = "-";
		while(in.hasNext())
		{
			String input = in.nextLine();
			String[] Input = input.split(" ");
			if(Input[0].equals("def"))
			{
				map2.remove(map1.get(Input[1]));
				map1.remove(Input[1]);	
				map1.put(Input[1], Integer.parseInt(Input[2]));
				map2.put(Integer.parseInt(Input[2]), Input[1]);
			}
			else if(Input[0].equals("clear"))
			{
				map1.clear();
				map2.clear();
			}
			else
			{
				boolean errorFound = false;
				int sum = 0;
				try
				{
					sum = map1.get(Input[1]);
					for(int i = 2; i < Input.length; i=i+2)
					{
						if(Input[i].equals(plus))
						{
							sum += map1.get(Input[i+1]);
						}
						else if(Input[i].equals(minus))
						{
							sum = sum - map1.get(Input[i+1]);
						}
					}
				}
				catch(NullPointerException e)
				{
					errorFound = true;
				}
				if(errorFound || !map2.containsKey(sum))
				{
					System.out.println(input.substring(5) + " unknown");
				}
				else
				{
					System.out.println(input.substring(5) + " " + map2.get(sum));
				}
			}
		}
	}
}