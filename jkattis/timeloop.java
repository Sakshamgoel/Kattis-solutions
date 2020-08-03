import java.util.Scanner;
public class timeloop
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        int num = userInput.nextInt();
        for(int i = 0; i < num; i++)
        {
            System.out.println((i+1) + " Abracadabra");
        }
    }
}
