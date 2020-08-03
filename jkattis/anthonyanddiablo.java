import java.util.*;
public class anthonyanddiablo
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();
        String[] Input = input.split(" ");
        double[] doubleinput = new double[2];
        for(int i = 0; i < 2; i++)
        {
            doubleinput[i] = Double.parseDouble(Input[i]);
        }
        double radius = Math.sqrt(doubleinput[0]/Math.PI);
        double  minPeri = (2 * doubleinput[0])/radius;
        if(doubleinput[1] >= minPeri)
        {
            System.out.println("Diablo is happy!");
        }
        else
        {
            System.out.println("Need more materials!");
        }
    }
}