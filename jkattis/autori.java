import java.util.Scanner;
public class autori
{
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      String input;
      input = userInput.nextLine();
      String[] arrofstr = input.split("-");
      for (int i = 0; i < arrofstr.length; i++)
      {
         System.out.print(arrofstr[i].charAt(0));
      }
   }
}