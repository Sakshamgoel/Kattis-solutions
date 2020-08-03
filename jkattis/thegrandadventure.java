import java.util.*;
public class thegrandadventure {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine());
		for(int i = 0; i < cases; i++) {
			String input = in.nextLine();
			Stack<String> stack = new Stack<String>();
			boolean possible = true;
			for(int j = 0; j < input.length(); j++) {
				String curr = Character.toString(input.charAt(j));
				if(curr.equals("$")) {
					stack.push("$");
				}
				if(curr.equals("|")) {
					stack.push("|");
				}
				if(curr.equals("*")) {
					stack.push("*");
				}
				if(curr.equals("b")) {
					if(stack.isEmpty()) {
						possible = false;
					}
					else if(!stack.pop().equals("$")) {
						possible = false;
					}
				}
				if(curr.equals("t")) {
					if(stack.isEmpty()) {
						possible = false;
					}
					else if(!stack.pop().equals("|")) {
						possible = false;
					}
				}
				if(curr.equals("j")) {
					if(stack.isEmpty()) {
						possible = false;
					}
					else if(!stack.pop().equals("*")) {
						possible = false;
					}
				}
			}
			if(!stack.isEmpty()) {
				possible = false;
			}
			if(possible) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
}