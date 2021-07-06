import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;

public class islandhopping {	

	static int[] parents;

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		int cases = Integer.parseInt(in.nextLine());

		for(int i = 0; i < cases; i++) {


			int islandCount = Integer.parseInt(in.nextLine());

			ArrayList<Point> points = new ArrayList<Point>();

			// Input island coords
			for(int j = 0; j < islandCount; j++) {

				String[] string = in.nextLine().split(" ");
				double x = Double.parseDouble(string[0]);
				double y = Double.parseDouble(string[1]);

				Point p = new Point(x, y);
				points.add(p);
			}

			// Queue to keep the distances
			PriorityQueue<Edge> q = new PriorityQueue<Edge>();

			for(int k = 0; k < islandCount; k++) {
				for(int j = 0; j < islandCount; j++) {
					double edgeLength = points.get(k).distance(points.get(j));
					if(k < j) {
						q.add(new Edge(k, j, edgeLength));
					}
				}
			}


			// for(Edge e : q) {
			// 	System.out.println("Start: " + e.start + " End: " + e.end + " Dist: " + e.dist);
			// }
			// System.out.println("PQ size: " + q.size());

			// System.out.println("\n\n");

			// union find to prevent cycles in kruskals
			parents = new int[islandCount];

			for (int k = 0; k < islandCount; k++) {
				parents[k] = k;
			}

			double bridgeDistance = 0;

			// Kruskals implemented
			while(!q.isEmpty()) {
				Edge curr = q.poll();

				//preventing cycles
				if(find(curr.start) != find(curr.end)) {
					
					bridgeDistance += curr.dist;
					union(curr.start, curr.end);
				}
			}

			System.out.println(bridgeDistance);
		}
	}

	public static void union(int a, int b) {
		int p_a = find(a);
		int p_b = find(b);

		if(p_a < p_b) parents[p_b] = p_a;
		if(p_b < p_a) parents[p_a] = p_b;
	}

	public static int find(int a) {
		int p_a = parents[a];

		if(p_a == a) return a;

		parents[a] = find(p_a);
		return parents[a];
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

class Edge implements Comparable<Edge> {

	int start;
	int end;

	double dist;

	public Edge(int startIn, int endIn, double distIn) {
		start = startIn;
		end = endIn;

		dist = distIn;
	}

	public int compareTo(Edge t) {
		return (int)((this.dist - t.dist) * 1000);
	}
}