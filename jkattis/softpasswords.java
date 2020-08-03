import java.util.*;
public class softpasswords
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String p = in.nextLine();
		boolean isEqual = false;
		String s3 = softpasswords.convert(s);
		char a = s.charAt(0);
		char b = s.charAt(s.length()-1);
		int baint = (int)b;
		int aint = (int)a;
		if(aint >= 48 && aint <= 57)
		{
			String s1 = s.substring(1);
			if(p.equals(s1))
			{
				isEqual = true;
			}
		}
		if(baint >= 48 && baint <= 57)
		{
			String s2 = s.substring(0,s.length()-1);
			if(p.equals(s2))
			{
				isEqual = true;
			}
		}
		if(p.equals(s) || p.equals(s3))
		{
			isEqual = true;
		}
		if(isEqual)
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
	}
	public static String convert(String str)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(str);
		int len = sb.length();
		for(int i = 0; i < len; i++)
		{
			Character c = sb.charAt(i);
			if(Character.isLowerCase(c))
			{
				c = Character.toUpperCase(c);
				sb.replace(i, i+1, c.toString());
			}
			else if(Character.isUpperCase(c))
			{
				c = Character.toLowerCase(c);
				sb.replace(i, i+1, c.toString());
			}
		}
		return sb.toString();
	}
}