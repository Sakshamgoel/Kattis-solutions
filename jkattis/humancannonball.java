import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class humancannonball {

	static Point start;
	static Point end;

	static double time;
	
	static double[][] graph;

	static ArrayList<Point> points;

	static int cannonCount;

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		String[] input = in.nextLine().split(" ");
		start = new Point(Double.parseDouble(input[0]), Double.parseDouble(input[1]));

		points = new ArrayList<Point>();

		points.add(start);

		input = in.nextLine().split(" ");
		end = new Point(Double.parseDouble(input[0]), Double.parseDouble(input[1]));

		cannonCount = Integer.parseInt(in.nextLine());

		graph = new double[cannonCount + 2][cannonCount + 2];

		for(int i = 0; i < cannonCount; i++) {

			input = in.nextLine().split(" ");
			Point p = new Point(Double.parseDouble(input[0]), Double.parseDouble(input[1]));
			
			points.add(p);
		}

		points.add(end);

		makeGraph();

		time = dijkstra();

		// for(int i = 0; i < graph.length; i++) {
		// 	for(int j = 0; j < graph.length; j++) {
		// 		System.out.print(graph[i][j] + "  ");
		// 	}
		// 	System.out.println();
		// }

		//System.out.println("Time = " + time);
		System.out.println(time);

	}

	public static void makeGraph() {

		for(Point p : points) {
			for(Point q : points) {
				//if the distance is less than 10
				if(p.distance(q) < 10) {
					graph[points.indexOf(p)][points.indexOf(q)] = p.distance(q) / 5.0;
				}
				//else if the distance is less than or equal to 50
				else if(p.distance(q) <= 50) {
					if(points.indexOf(p) != 0 && points.indexOf(p) != cannonCount + 1) {
						graph[points.indexOf(p)][points.indexOf(q)] = 2 + ((50 - p.distance(q)) / 5.0);	
					} else {
						graph[points.indexOf(p)][points.indexOf(q)] = p.distance(q) / 5.0;
					}
				}
				//if greater than 50
				else {
					if(points.indexOf(p) != 0 && points.indexOf(p) != cannonCount + 1) {
						graph[points.indexOf(p)][points.indexOf(q)] = 2 + ((p.distance(q) - 50) / 5.0);	
					} else {
						graph[points.indexOf(p)][points.indexOf(q)] = (p.distance(q)) / 5.0;
					}
				}
			}
		}
	}

	public static double dijkstra() {
		double[] distances = new double[cannonCount + 2];

		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();

		Tuple start = new Tuple(0, 0);
		pq.add(start);

		while(!pq.isEmpty()) {
			Tuple curr = pq.poll();

			distances[curr.index] = curr.dist;

			if(curr.index == cannonCount + 1) break;

			for(int i = 0; i < cannonCount + 2; i++) {
				if(i == curr.index || distances[i] != 0) continue;

				Tuple temp = new Tuple(i, curr.dist + graph[curr.index][i]);
				pq.add(temp);
			}

		}

		return distances[cannonCount + 1];

	}
}

class Point {

	double x;
	double y;

	public Point(double xIn, double yIn) {
		x = xIn;
		y = yIn;
	}

	public double distance(Point p) {
		return Math.sqrt(Math.pow((x - p.x), 2) + Math.pow((y - p.y), 2));
	}

}

class Tuple implements Comparable<Tuple> {

	int index;
	double dist;

	public Tuple(int indexIn, double distIn) {
		index = indexIn;
		dist = distIn;
	}
	//multiply by 1000 to increase the accuracy of compareTo
	public int compareTo(Tuple t) {
		return (int)((this.dist - t.dist) * 1000);
	}
}