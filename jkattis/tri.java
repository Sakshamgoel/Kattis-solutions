import java.util.Scanner;
public class tri
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        boolean left = true;
        if(a/b ==c && left)
        {
            System.out.println(a+"/"+b+"="+c);
            left = false;
        }
        else if(a+b==c && left)
        {
            System.out.println(a+"+"+b+"="+c);
            left = false;
        }
        else if(a-b==c && left)
        {
            System.out.println(a+"-"+b+"="+c);
            left = false;
        }
        else if(a*b==c && left)
        {
            System.out.println(a+"*"+b+"="+c);
            left = false;
        }
        else if(b+c==a && left)
        {
            System.out.println(a+"="+b+"+"+c);
            left = false;
        }
        else if(b-c==a && left)
        {
            System.out.println(a+"="+b+"-"+c);
            left = false;
        }
        else if(b*c==a && left)
        {
            System.out.println(a+"="+b+"*"+c);
            left = false;
        }
        else if(b/c==a && left)
        {
            System.out.println(a+"="+b+"/"+c);
            left = false;
        }
    }
}