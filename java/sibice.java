import java.util.Scanner;
public class sibice
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        int total = userInput.nextInt();
        int width = userInput.nextInt();
        int length = userInput.nextInt();
        double hypo = Math.sqrt(width*width + length*length);
        for(int i = 0; i < total; i++)
        {
            int match = userInput.nextInt();
            if(match > hypo)
            {
                System.out.println("NE");
            }
            else
            {
                System.out.println("DA");
            }
        }
    }
}
