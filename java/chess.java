import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class chess {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int cases = Integer.parseInt(in.nextLine());



		for(int k = 0; k < cases; k++) {
			String[] input = in.nextLine().split(" ");

			Position start = new Position(input[0].compareTo("A"), Integer.parseInt(input[1]) - 1);
			Position end = new Position(input[2].compareTo("A"), Integer.parseInt(input[3]) - 1);

			//if start and end on opposite colors
			//each color is on either an even square or odd square
			if(start.even) {
				if(!end.even) {
					System.out.println("Impossible");
					continue;
				}
			} else {
				if(end.even) {
					System.out.println("Impossible");
					continue;
				}
			}

			Tuple finalPosition = dfs(start, end);


			ArrayList<String> list = finalPosition.list();

			Collections.reverse(list);

			list.add(new String(input[2] + " " + Integer.parseInt(input[3])));

			String output = "";

			int count = -1;
			for(String s : list) {
				output += s + " ";
				count++;
			}

			System.out.println(count + " " + output.trim());


		}
	}

	public static Tuple dfs(Position start, Position end) {

		Queue<Tuple> q = new LinkedList<Tuple>();

		boolean[][] visited = new boolean[8][8];

		q.add(new Tuple(start.x, start.y, null, -1, 0));

			while(!q.isEmpty()) {
				Tuple curr = q.poll();

				if(curr.x == end.x && curr.y == end.y) {
					if(curr.count <= 3) {
						return curr;
					} else {
						continue;
					}
				}

				//left up :		-1 +1
				if(curr.x > 0 && curr.y < 7 && !visited[curr.x - 1][curr.y + 1]) {
					//visited[curr.x - 1][curr.y + 1] = true;

					if(curr.direction == 1) {
						q.add(new Tuple(curr.x - 1, curr.y + 1, curr, 1, curr.count));
					} else {
						q.add(new Tuple(curr.x - 1, curr.y + 1, curr, 1, curr.count + 1));	
					}
				}
				//left down :	-1 -1
				if(curr.x > 0 && curr.y > 0 && !visited[curr.x - 1][curr.y - 1]) {
					//visited[curr.x - 1][curr.y - 1] = true;

					if(curr.direction == 2) {
						q.add(new Tuple(curr.x - 1, curr.y - 1, curr, 2, curr.count));
					} else {
						q.add(new Tuple(curr.x - 1, curr.y - 1, curr, 2, curr.count + 1));
					}
				}
				//right up :	+1 +1
				if(curr.x < 7 && curr.y < 7  && !visited[curr.x + 1][curr.y + 1]) {
					//visited[curr.x + 1][curr.y + 1] = true;

					if(curr.direction == 3) {
						q.add(new Tuple(curr.x + 1, curr.y + 1, curr, 3, curr.count));
					} else {
						q.add(new Tuple(curr.x + 1, curr.y + 1, curr, 3, curr.count + 1));
					}
				}
				//right down :	+1 -1
				if(curr.x < 7 && curr.y > 0 && !visited[curr.x + 1][curr.y - 1]) {
					//visited[curr.x + 1][curr.y - 1] = true;

					if(curr.direction == 4) {
						q.add(new Tuple(curr.x + 1, curr.y - 1, curr, 4, curr.count));
					} else {
						q.add(new Tuple(curr.x + 1, curr.y - 1, curr, 4, curr.count + 1));
					}
				}
			}
		
		return null;
	}
}

class Position {

	int x, y;
	boolean even;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;

		even = (x + y) % 2 == 0;
	}
}

class Tuple {
	int x, y;
	Tuple pre;
	
	//left up = 1, left down = 2, right up = 3, right down = 4
	int direction;

	int count;

	public Tuple(int x, int y, Tuple pre, int direction, int count) {
		this.x = x;
		this.y = y;
		this.pre = pre;
		this.direction = direction;
		this.count = count;
	}

	public ArrayList<String> list() {
		Tuple temp = this;
		ArrayList<String> list = new ArrayList<String>();
		while(temp != null) {
			if(temp.pre != null && temp.direction != temp.pre.direction) {
				list.add(new String(Character.toString((char) 65 + temp.pre.x) + " " + (temp.pre.y + 1)));
			}
			temp = temp.pre;
		}

		return list;

	}


}