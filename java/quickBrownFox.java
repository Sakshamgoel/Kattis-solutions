import java.util.Scanner;
public class quickBrownFox
{
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      
      int input = 0;
      String alpha = "abcdefghijklmnopqrstuvwxyz";
      input = Integer.parseInt(userInput.nextLine());
      String[] stringInput = new String[input];
      for (int i = 0; i <= input - 1; i++)
      {
         stringInput[i] = userInput.nextLine();
         stringInput[i] = stringInput[i].toLowerCase();
      }
      for (int i = 0; i <= stringInput.length - 1; i++)
      {
         boolean check = true, panCheck = true;
         String remaining = "";
         for (int j = 0; j < 26; j++)
         {
            check = stringInput[i].contains(alpha.substring(j, j + 1));
            if (!check)
            {
               panCheck = false;
               remaining += alpha.charAt(j);
            }
         }
         if (panCheck)
         {
            System.out.println("pangram");
         }
         else
         {
            System.out.println("missing " + remaining);
         }
      }
   }
}
