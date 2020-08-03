import java.util.Scanner;
public class earlywinter
{
    public static void main(String[] args)
    {
        int the = 0;
        Scanner userInput = new Scanner(System.in);
        int years = userInput.nextInt();
        int daysm = userInput.nextInt();
        int finalYear = 0;
        int[] days = new int[years];
        for(int i = 0; i < years; i++)
        {
            days[i] = userInput.nextInt();
        }
        try
        {
            for(int i = 0; i < years; i++)
            {
                if(daysm >= days[0])
                {
                    System.out.println("It hadn't snowed this early in 0 years!");
                    the = 1;
                    break;
                }
                if(daysm < days[i])
                {
                    the = 2;
                    if(daysm >= days[i + 1])
                    {
                        the = 3;
                        finalYear = i + 1;
                        break;
                    }
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {;}
        if(the == 3)
        {
            System.out.println("It hadn't snowed this early in " + finalYear + " years!");
        }
        else if (the == 2)
        {
            System.out.println("It had never snowed this early!");
        }
    }
}