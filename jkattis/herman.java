import java.util.Scanner;
public class herman
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int radius = in.nextInt();
        double hermanAr = 2*radius*radius;
        double normal = Math.PI*radius*radius;
        System.out.println(normal);
        System.out.println(hermanAr);
    }
}