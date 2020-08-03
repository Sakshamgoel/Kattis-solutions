import java.util.*;
public class crosscountry
{
	static int numOfIntersections;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		numOfIntersections = in.nextInt();
		int start = in.nextInt();
		int stop = in.nextInt();
		int[][] graph = new int[numOfIntersections][numOfIntersections];
		for(int i = 0; i < numOfIntersections; i++)
		{
			for(int j = 0; j < numOfIntersections; j++)
			{
				graph[i][j] = in.nextInt();
			}
		}
		int time = timeCalc(graph, start, stop);
		System.out.println(time);
	}
	public static int timeCalc(int[][] graph, int start, int stop)
	{
		int[] distances = new int[numOfIntersections];
		PriorityQueue<Tuple> q = new PriorityQueue();
		q.add(new Tuple(start, 0));
		while(!q.isEmpty())
		{
			Tuple curr = q.poll();
			distances[curr.index] = curr.distance;
			if(curr.index == stop) break;

			for(int i = 0; i < numOfIntersections; i++) {
				
				if(curr.index == i || distances[i] != 0) continue;

				Tuple secCurr = new Tuple(i, curr.distance + graph[curr.index][i]);
				q.add(secCurr);
			}
		}
		return distances[stop];
	}
}
class Tuple implements Comparable<Tuple>
	{
		int index, distance;
		public Tuple(int indexIn, int distanceIn)
		{
			index = indexIn;
			distance = distanceIn;
		}
		public int compareTo(Tuple t)
		{
			return this.distance - t.distance;
		}
	}