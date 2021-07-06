import java.util.Scanner;
public class twostones
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if(num%2==0)
        {
            System.out.println("Bob");
        }
        else
        {
            System.out.println("Alice");
        }
    }
}
