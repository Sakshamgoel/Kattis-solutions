import java.util.Scanner;
public class speedlimit
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        while(cases != -1)
        {
            int[] speed = new int[cases];
            int[] hours = new int[cases];
            int distance = 0;
            for(int i = 0; i < cases; i++)
            {
                speed[i] = in.nextInt();
                hours[i] = in.nextInt();
            }
            for(int i = cases-1; i > 0; i--)
            {
                hours[i] = hours[i] - hours[i-1];
            }
            for(int i = 0; i < cases; i++)
            {
                distance += (speed[i]*hours[i]);
            }
            System.out.println(distance + " miles");
            cases = in.nextInt();
        }
    }
}