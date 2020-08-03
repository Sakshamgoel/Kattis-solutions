import java.util.Scanner;
public class mixedFractions
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        int num = userInput.nextInt();
        int den = userInput.nextInt();
        while(num != 0 && den != 0)
        {
            int whole = num / den;
            int remain = num % den;
            System.out.println(whole + " " + remain +  " / " + den);
            num = userInput.nextInt();
            den = userInput.nextInt();
        }   
    }
} 
