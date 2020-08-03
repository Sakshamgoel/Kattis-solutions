import java.util.*;
public class tgif
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String Input[] = input.split(" ");
		String janDay = in.nextLine();
		int currDate = Integer.parseInt(Input[0]) - 1;
		String currMonth = Input[1];
		int month = monthCalc(currMonth);
		int totalDays = totalDaysCalc(month, currDate);
		System.out.println(isFriday(totalDays, janDay));
		//System.out.println(totalDays);
	}
	public static String isFriday(int totalDays, String janDay)
	{	
		int leapDays = totalDays;
		if(totalDays >= 60)
		{
			leapDays++;
		}
		leapDays += dayCalc(janDay);
		totalDays += dayCalc(janDay);
		boolean leapTrue = leapDays % 7 == 0;
		boolean totalTrue = totalDays % 7 == 0;
		String result = "";
		if(leapTrue && totalTrue)
		{
			result = "TGIF";
		}
		else if(!(leapTrue || totalTrue))
		{
			result = ":(";
		}
		else
		{
			result = "not sure";
		}
		return result;
	}
	public static int monthCalc(String month)
	{
		int monthInt = 0;
		switch(month)
		{
			case "JAN": monthInt = 1; break;
			case "FEB": monthInt = 2; break;
			case "MAR": monthInt = 3; break;
			case "APR": monthInt = 4; break;
			case "MAY": monthInt = 5; break;
			case "JUN": monthInt = 6; break;
			case "JUL": monthInt = 7; break;
			case "AUG": monthInt = 8; break;
			case "SEP": monthInt = 9; break;
			case "OCT": monthInt = 10; break;
			case "NOV": monthInt = 11; break;
			case "DEC": monthInt = 12; break;
		}
		monthInt = monthInt - 1;
		return monthInt;
	}
	public static int totalDaysCalc(int month, int currDate)
	{
		int curMonth = month;
		int totalDays = currDate;
		while(curMonth != 0)
		{
			if(curMonth == 11 || curMonth == 4 || curMonth == 6 || curMonth == 9)
			{
				totalDays += 30;
			}
			else if(curMonth == 2)
			{
				totalDays += 28;
			}
			else
			{
				totalDays += 31;
			}
			curMonth = curMonth - 1;
		}
		return totalDays;
	}
	public static int dayCalc(String janDay)
	{
		int day = 0;
		switch(janDay)
		{
			case "FRI": day = 0; break;
			case "SAT": day = 1; break;
			case "SUN": day = 2; break;
			case "MON": day = 3; break;
			case "TUE": day = 4; break;
			case "WED": day = 5; break;
			case "THU": day = 6; break;
		}
		return day;
	}
}