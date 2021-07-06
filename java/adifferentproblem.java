import java.util.*;
public class adifferentproblem
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        long a = 0, b = 0;
        short c = 3;
        while(userInput.hasNext())
        {
            a = userInput.nextLong();
            b = userInput.nextLong();
            System.out.println(Math.abs(a-b));
        }
    }
}