import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;

public class metaprogramming {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashSet<String> names = new HashSet<String>();

		while(in.hasNext()) {

			String[] input = in.nextLine().split(" ");
			
			if(input[0].equals("define")) {
				map.put(input[2], Integer.parseInt(input[1]));
				names.add(input[2]);
			} else {
				if(!names.contains(input[1]) || !names.contains(input[3])) {
					System.out.println("undefined");
					continue;
				} else {
					int num1 = map.get(input[1]);
					int num2 = map.get(input[3]);

					if(input[2].equals("<")) {
						if(num1 < num2) {
							System.out.println("true");
						} else {
							System.out.println("false");
						}
					} else if(input[2].equals(">")) {
						if(num1 > num2) {
							System.out.println("true");
						} else {
							System.out.println("false");
						}
					} else {
						if(num1 == num2) {
							System.out.println("true");
						} else {
							System.out.println("false");
						}
					}
				}

			}

		}
	}
}