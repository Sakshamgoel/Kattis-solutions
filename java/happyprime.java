import java.util.*;
public class happyprime
{
	static final int MAX = 10001;
	static boolean[] sieve = new boolean[MAX];
	public static void main(String[] args) {
		makeSieve();
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for(int i = 0; i < cases; i++)
		{
			int caseNo = in.nextInt();
			int num = in.nextInt();
			//check prime
			boolean good = (sieve[num] && isHappy(num, new HashSet<Integer>()));
			if(good) {
				System.out.println(caseNo + " " + num + " YES");
			}
			else {
				System.out.println(caseNo + " " + num + " NO");
			}
		}
	}
	public static boolean isHappy(int num, HashSet<Integer> seen) {
		int sum = 0;
		int numIn = num;
		while(numIn != 0)
		{
			int curr = numIn % 10;
			sum += (curr*curr);
			numIn = (int)numIn/10;
		}
		if(sum == 1) {
			return true;
		}
		if(seen.contains(sum)) {
			return false;
		}
		seen.add(sum);
		return isHappy(sum, seen);
	}
	public static void makeSieve() {
		Arrays.fill(sieve, true);
		sieve[0] = false;
		sieve[1] = false;
		for(int i = 2; i < MAX; i++)
		{
			if(!sieve[i])
			{
				continue;
			}
			//mark multiples as composite
			for(int j = i*i; j < MAX; j+=i)
			{
				sieve[j] = false;
			}
		}
	}
}