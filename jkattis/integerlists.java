import java.util.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class integerlists {

	public static void main(String[] args) {

		Kattio in = new Kattio(System.in);
		int cases = Integer.parseInt(in.getWord());
		for(int i = 0; i < cases; i++) {
			
			Deque<Integer> deq = new LinkedList<Integer>();
			
			String command = in.getWord();
			int listLength = Integer.parseInt(in.getWord());
			String numList = in.getWord();
			
			numList = numList.substring(1, numList.length() - 1);
			String[] list = numList.split(",");

			for(int j = 0; j < listLength; j++) {
				deq.offerLast(Integer.parseInt(list[j]));
			}

			String result = output(deq, command);

			if(result != null) in.println(result);
			else in.println("error");
		}
		in.close();
	}

	public static String toString(Deque deqIn, boolean isFrontIn) {
		
		if(deqIn.size() == 0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		int dequeSize = deqIn.size();
		if(isFrontIn) {
			for(int i = 0; i < dequeSize; i++) {
				sb.append(deqIn.pollFirst());
				sb.append(",");
			}
		} else {
			for(int i = 0; i < dequeSize; i++) {
				sb.append(deqIn.pollLast());
				sb.append(",");
			}
		}
		sb.delete(sb.length() - 1, sb.length());
		sb.append("]");
		String result = sb.toString();
		return result;
	}

	public static String output(Deque deqIn, String commandIn) {
		
		boolean isFront = true;
		for(int i = 0; i < commandIn.length(); i++) {
			if(commandIn.charAt(i) == 'R') {
				isFront = isFront ? false : true;
			} else {
				if(deqIn.size() == 0) {
					return null;
				} else if(isFront) {
					deqIn.pollFirst();
				} else {
					deqIn.pollLast();
				}
			}
		}
		String result = toString(deqIn, isFront);
		return result;
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
