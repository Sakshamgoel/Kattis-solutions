import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class dreamer {

	static HashSet<String> possibleCombos;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int cases = Integer.parseInt(in.nextLine());

		for(int i = 0; i < cases; i++) {


			String dateInChar = in.nextLine();

			String[] date = dateInChar.split(" ");

			ArrayList<Integer> list = new ArrayList<Integer>();

			for(int k = 0; k < 2; k++) {
				for(int j = 0; j < 2; j++) {
					list.add(Character.getNumericValue(date[k].charAt(j)));
				}
			}
			for(int k = 0; k < 4; k++) {
				list.add(Character.getNumericValue(date[2].charAt(k)));
			}

			possibleCombos = new HashSet<String>();

			findPossibleCombos(list, "");

			//System.out.println("Size: " + possibleCombos.size());

			ArrayList<String> finalList = new ArrayList<String>(possibleCombos);

			Collections.sort(finalList, new SortDate());

			System.out.print(finalList.size());
			if(finalList.size() > 0) {
				String earliest = finalList.get(0);
				System.out.println(" " + earliest.substring(0, 2) + " " + earliest.substring(2, 4) + " " + earliest.substring(4));
			} else {
				System.out.println();
			}

		}
	}

	public static boolean validDate(String date) {

		int day = Integer.parseInt(date.substring(0, 2));
		int month = Integer.parseInt(date.substring(2, 4));
		int year = Integer.parseInt(date.substring(4));

		if(year < 2000) return false;
		if(month > 12 || month == 0) return false;
		if(day > 31 || day == 0) return false;
		if((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) return false;
		
		if(month == 2) {
			if(!leapYear(year) && day > 28) return false;
			if(day > 29) return false;
		}

		return true;
	}

	public static boolean leapYear(int year) {
		if(year % 4 != 0) return false;
		if(year % 100 == 0 && year % 400 != 0) return false;

		return true;
	}

	public static void findPossibleCombos(ArrayList<Integer> list, String right) {

		if(right.length() == 8) {
			if(validDate(right)) possibleCombos.add(right);
			return;
		}

		for(int i = 0; i < list.size(); i++) {

			String tempRight = new String(right);
			ArrayList<Integer> tempList = new ArrayList<Integer>(list);
			int currInt = list.get(i);
			tempRight += currInt;
			tempList.remove(i);

			findPossibleCombos(tempList, tempRight);
		}
	}
}

class SortDate implements Comparator<String> {

	public int compare(String a, String b) {
		if(a.substring(4).equals(b.substring(4))) {
			if(a.substring(2, 4).equals(b.substring(2, 4))) {
				return Integer.parseInt(a.substring(0, 2)) - Integer.parseInt(b.substring(0, 2));
			}
			return Integer.parseInt(a.substring(2, 4)) - Integer.parseInt(b.substring(2, 4));
		}
		return Integer.parseInt(a.substring(4)) - Integer.parseInt(b.substring(4));
	}
}