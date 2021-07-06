import java.util.Scanner;
public class apaxianparent
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String output = "";
        String[] input = a.split(" ");
        char ch = input[0].charAt(input[0].length()-1);
        if(ch == 'x' && input[0].charAt(input[0].length()-2) == 'e')
        {
            output = input[0] + input[1];
        }
        else if(ch == 'e' || ch == 'a' || ch == 'i' || ch == 'o' || ch == 'u')
        {
            input[0] = input[0].substring(0,input[0].length()-1);
            output = input[0] + "ex" + input[1];
        }
        else
        {
            output = input[0] + "ex" + input[1];
        }
        System.out.println(output);
    }
}