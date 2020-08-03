import java.util.Scanner;
public class areal
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        long area = userInput.nextLong();
        double fence = 4 *  Math.sqrt(area);
        System.out.println(fence);
    }
}