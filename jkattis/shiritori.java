import java.util.*;
public class shiritori
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		HashSet<String> allWords = new HashSet<String>();
		int num = Integer.parseInt(in.nextLine());
		int playerTurn = 0;
		boolean playerLoss = false;
		String[] input = new String[num];
		for(int i = 0; i < num; i++)
		{
			//System.out.println(i);
			input[i] = in.nextLine();		
		}
		for(int i = 0; i < num; i++)
		{
			playerTurn += 1;
			if(allWords.contains(input[i]))
			{
				playerLoss = true;
				break;
			}
			if(i >= 1)
			{
				char now = input[i].charAt(0);
				char previous = input[i-1].charAt(input[i-1].length()-1);
				if(now != previous)
				{
					playerLoss = true;
					break;
				}
			}
			allWords.add(input[i]);
		}
		int player = 0;
		if(playerTurn % 2 == 0) player = 2;
		else player = 1;
		if(playerLoss)
		{
			System.out.println("Player " + player + " lost");
		}
		else
		{
			System.out.println("Fair Game");
		}
	}
}