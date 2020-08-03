import java.util.*;
public class kitten
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Integer initialVal = Integer.parseInt(in.nextLine());
		HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
		String input = in.nextLine();
		String[] Input = input.split(" ");
		Integer finalBranch = Integer.parseInt(Input[0]);
		while(!input.equals("-1"))
		{
			Input = input.split(" ");
			Integer parent = Integer.parseInt(Input[0]);
			for(int i = 1; i < Input.length; i++)
			{
				Integer child = Integer.parseInt(Input[i]);
				data.put(child, parent);
			}
			input = in.nextLine();
		}
		System.out.println(DFS(initialVal, finalBranch, data));
	}
	public static String DFS(Integer initialVal, Integer finalBranch, HashMap<Integer, Integer> data)
	{
		String result = initialVal + " ";
		Integer getParent = data.get(initialVal);
		while(getParent != finalBranch)
		{
			result += getParent + " ";
			getParent = data.get(getParent);
		}
		result += finalBranch;
		return result;
	}
}