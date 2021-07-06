import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
public class akcija
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        int cases = userInput.nextInt();
        Integer[] price = new Integer[cases];
        for(int i = 0; i < cases; i++)
        {
            price[i] = userInput.nextInt();
        }
        Arrays.sort(price, Collections.reverseOrder());
        int sum = 0;
        int j = 2;
        while(j < cases)
        {
            price[j]= 0;
            j += 3;
        }
        for(int i = 0; i < cases; i++)
        {
            sum += price[i];
        }
        System.out.println(sum);
    }
}