import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;
public class fourThought {

	public static HashMap<Integer, String> map;
	public static HashSet<Integer> numMap;

	public static HashMap<Integer, String> functions;

	public static void main(String[] args) {
		map = new HashMap<Integer, String>();
		functions = new HashMap<Integer, String>();
		numMap = new HashSet<Integer>();
		functions.put(0, " + ");
		functions.put(1, " - ");
		functions.put(2, " * ");
		functions.put(3, " / ");
		makeSieve();
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		for(int i = 0; i < num; i++) {
			int n = in.nextInt();
			if(numMap.contains(n)) {
				System.out.println(map.get(n));
			} else {
				System.out.println("no solution");
			}
		}
	}
	public static void makeSieve() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 4; k++) {
					
					String n = 4 + functions.get(i) + 4 + functions.get(j) + 4 + functions.get(k) + 4;
					String toCalc = functions.get(i) + functions.get(j) + functions.get(k);
					int num = calculate(n);
					n += " = " + num;
					n = n.trim();
					map.put(num, n);
					numMap.add(num);
				}
			}
		}	
	}
	public static int calculate(String n) {
		boolean plus = false;
		boolean minus = false;
		boolean mult = false;
		boolean div = false;
		String[] input = n.split(" ");
		int taken = 0;
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(input));
		while(list.size() > 1) {
			plus = false;
			minus = false;
			mult = false;
			div = false;
			for(int i = 1; i < list.size(); i += 2) {
				if(list.get(i).equals("/")) {
					int a = Integer.parseInt(list.get(i - 1)) / Integer.parseInt(list.get(i + 1));
					list.remove(i - 1);
					list.remove(i - 1);
					list.remove(i - 1);
					list.add(i - 1, String.valueOf(a));
					div = true;
					break;
				}
			}
			if(div) { continue; }
			for(int i = 1; i < list.size(); i += 2) {
				if(list.get(i).equals("*")) {
					int a = Integer.parseInt(list.get(i - 1)) * Integer.parseInt(list.get(i + 1));
					list.remove(i - 1);
					list.remove(i - 1);
					list.remove(i - 1);
					list.add(i - 1, String.valueOf(a));
					mult = true;
					break;
				}
			}
			if(mult) { continue; }
			for(int i = 1; i < list.size(); i += 2) {
				if(list.get(i).equals("+")) {
					int a = Integer.parseInt(list.get(i - 1)) + Integer.parseInt(list.get(i + 1));
					list.remove(i - 1);
					list.remove(i - 1);
					list.remove(i - 1);
					list.add(i - 1, String.valueOf(a));
					plus = true;
					break;
				}
			}
			if(plus) { continue; }
			for(int i = 1; i < list.size(); i += 2) {
				if(list.get(i).equals("-")) {
					int a = Integer.parseInt(list.get(i - 1)) - Integer.parseInt(list.get(i + 1));
					list.remove(i - 1);
					list.remove(i - 1);
					list.remove(i - 1);
					list.add(i - 1, String.valueOf(a));
					minus = true;
					break;
				}
			}
			if(minus) { continue; }
		}
		return Integer.parseInt(list.get(0));
	}
}