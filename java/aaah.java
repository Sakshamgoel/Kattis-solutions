import java.util.*;
public class aaah
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        String jonSay = userInput.nextLine().trim();
        String doctor = userInput.nextLine().trim();
        int a = jonSay.indexOf('h');
        int b = doctor.indexOf('h');
        if(a >= b)
        {
            System.out.println("go");
        }
        else
        {
            System.out.println("no");
        }
    }
}