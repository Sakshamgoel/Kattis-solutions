import java.util.*;
public class abc
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();
        input = input.trim();
        String[] numInput = input.split(" ");
        int[] numinput = new int[3];
        for(int i = 0; i < 3; i++)
        {
            numinput[i] = Integer.parseInt(numInput[i]);
        }
        Arrays.sort(numinput);
        String stringInput = userInput.nextLine();
        int[] seq = new int[3];
        for(int i = 0; i < 3; i++)
        {
            if(stringInput.charAt(i) == 'A')
            {
                seq[i] = 0;
            }
            else if(stringInput.charAt(i) == 'B')
            {
                seq[i] = 1;
            }
            else
            {
                seq[i] = 2;
            }
        }
        System.out.println(numinput[seq[0]] + " " + numinput[seq[1]] + " " + numinput[seq[2]]);
    }
}