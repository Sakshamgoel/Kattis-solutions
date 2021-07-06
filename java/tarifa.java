import java.util.Scanner;
public class tarifa
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int perMonth = in.nextInt();
        int cases = in.nextInt();
        int left = 0;
        for(int i = 0; i < cases; i++)
        {
            int used = in.nextInt();
            left += (perMonth - used);
        }
        left += perMonth;
        System.out.println(left);
    }
}