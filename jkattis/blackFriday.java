import java.util.ArrayList;
import java.util.Scanner;
public class blackFriday
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        int cases = userInput.nextInt();
        int myInt = 0;
        ArrayList<Integer> total = new ArrayList<Integer>();
        int[] dice = new int[6];
        for(int i = 0; i < cases; i++)
        {
            int num = userInput.nextInt();
            total.add(num);
            dice[num-1]++;
        }
        for(int i = 5; i >= 0; i--)
        {
            if(dice[i]==1)
            {
                myInt = i + 1;
                break;
            }
        }
        if(myInt > 0)
        {
            System.out.println(total.indexOf(myInt) + 1);
        }
        else
        {
            System.out.println("none");
        }
    }
}
