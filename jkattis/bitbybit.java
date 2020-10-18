import java.util.Scanner;

public class bitbybit {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		String input = in.nextLine();

		while(!input.equals("0")) {
			boolean[] visited = new boolean[32];
			int[] values = new int[32];

			int cases = Integer.parseInt(input);

			for(int i = 0; i < cases; i++) {
				String[] caseInput = in.nextLine().split(" ");
				String command = caseInput[0];
				int num1 = Integer.parseInt(caseInput[1]);

				if(command.equals("SET")) {
					visited[num1] = true;
					values[num1] = 1;

				} else if(command.equals("CLEAR")) {
					visited[num1] = true;
					values[num1] = 0;
				
				} else if(command.equals("OR")) {
					int num2 = Integer.parseInt(caseInput[2]);

					if(values[num2] == 1 || values[num1] == 1) {
						values[num1] = 1;
						visited[num1] = true;
					} else if(!visited[num2]) {
						values[num1] = 0;
						visited[num1] = false;
					}

				} else {
					int num2 = Integer.parseInt(caseInput[2]);

					if((visited[num2] && values[num2] == 0) || (visited[num1] && values[num1] == 0)) {
						visited[num1] = true;
						values[num1] = 0;
					} else if(!visited[num2] || !visited[num1]) {
						visited[num1] = false;
						values[num1] = 0;
					} 

				}
			}
			for(int i = 31; i >= 0; i--) {
				if(visited[i]) System.out.print(values[i]);
				else System.out.print("?");
			}
			System.out.println();
			input = in.nextLine();
		}
	}
}