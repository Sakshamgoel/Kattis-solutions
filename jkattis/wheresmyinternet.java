import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
public class wheresmyinternet {
	static int[] parents;
	static boolean something = false;
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in);
		int n = io.getInt();
		int m = io.getInt();
		parents = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			parents[i] = i;
		}
		for(int i = 0; i < m; i++) {
			int num1 = io.getInt();
			int num2 = io.getInt();
			union(num1, num2);
		}
		for(int i = 1; i <= n; i++) {
			if(find(i) != 1) {
				io.println(i);
				something = true;
			}
		}
		if(!something) io.println("Connected");
		io.close();
	}
	static void union(int a, int b) {
		int p_a = find(a);
		int p_b = find(b);
		if(p_a < p_b) parents[p_b] = p_a;
		if(p_b < p_a) parents[p_a] = p_b;
	}
	static int find(int a) {
		int p_a = parents[a];
		if(p_a == a) {
			return p_a;
		}
		parents[a] = find(p_a);
		return parents[a];
	}
}
class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
	super(new BufferedOutputStream(System.out));
	r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
	super(new BufferedOutputStream(o));
	r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
	return peekToken() != null;
    }

    public int getInt() {
	return Integer.parseInt(nextToken());
    }

    public double getDouble() { 
	return Double.parseDouble(nextToken());
    }

    public long getLong() {
	return Long.parseLong(nextToken());
    }

    public String getWord() {
	return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
	if (token == null) 
	    try {
		while (st == null || !st.hasMoreTokens()) {
		    line = r.readLine();
		    if (line == null) return null;
		    st = new StringTokenizer(line);
		}
		token = st.nextToken();
	    } catch (IOException e) { }
	return token;
    }

    private String nextToken() {
	String ans = peekToken();
	token = null;
	return ans;
    }
}