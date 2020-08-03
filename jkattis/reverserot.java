import java.util.*;
public class reverserot
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		while(!input.equals("0"))
		{
			String[] Input = input.split(" ");
			int rotation = Integer.parseInt(Input[0]);
			System.out.println(rotate(rotation, Input[1]));
			input = in.nextLine();
		}
	}
	public static String rotate(int rotation, String input)
	{
		String[] list = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "_", "."};
		List theList = new ArrayList<String>();
		theList = Arrays.asList(list);
		String result = "";
		for(int i = input.length() - 1; i >= 0; i--)
		{
			int rot = theList.indexOf(String.valueOf(input.charAt(i)));
			rot = (rot + rotation) % 28;
			result += theList.get(rot).toString();
		}
		return result;
	}
}