import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Collections;

public class warehouse {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int cases = Integer.parseInt(in.nextLine());

		for(int i = 0; i < cases; i++) {

			HashSet<String> nameList = new HashSet<String>();
			ArrayList<Toy> toyList = new ArrayList<Toy>();

			int cases2 = Integer.parseInt(in.nextLine());

			for(int j = 0; j < cases2; j++) {
				
				String[] input = in.nextLine().split(" ");

				String toyName = input[0];
				int toyCount = Integer.parseInt(input[1]);

				if(!nameList.contains(toyName)) {
					nameList.add(toyName);
					Toy t = new Toy(toyName, toyCount);
					toyList.add(t);
				} else {
					for(Toy t : toyList) {
						if(toyName.equals(t.name)) {
							t.count += toyCount;
						}
					}
				}

			}
			Collections.sort(toyList);

			System.out.println(toyList.size());
			for(Toy t : toyList) {
				System.out.println(t.name + " " + t.count);
			}

		}
	}
}

class Toy implements Comparable<Toy> {

	String name;
	int count;
	public Toy(String nameIn, int countIn) {

		name = nameIn;
		count = countIn;
	}

	@Override
	public int compareTo(Toy t) {
		if(this.count == t.count) {
			return this.name.compareTo(t.name);
		}
		return t.count - this.count;
	}
}