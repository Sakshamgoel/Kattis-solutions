import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class cd {
	public static void main(String[] args) {

		Kattio io = new Kattio(System.in, System.out);

		int nCdCount = io.getInt();
		int mCdCount = io.getInt();

		while(nCdCount != 0 || mCdCount != 0) {

			int count = 0;

			HashSet<Integer> nCd = new HashSet<Integer>();
			HashSet<Integer> mCd = new HashSet<Integer>();

			for(int i = 0; i < nCdCount; i++) {
				nCd.add(io.getInt());
			}
			for(int i = 0; i < mCdCount; i++) {
				mCd.add(io.getInt());
			}
			for(int n : nCd) {
				if(mCd.contains(n)) count++;
			}

			System.out.println(count);
			
			nCdCount = io.getInt();
			mCdCount = io.getInt();
		}
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
