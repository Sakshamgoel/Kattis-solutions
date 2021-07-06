import java.util.Scanner;
public class babyBites
{
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      String[] indiNum;
      String totalBites;
      int numberBites;
      boolean sense = true;
      numberBites = Integer.parseInt(userInput.nextLine());
      totalBites = userInput.nextLine();
      indiNum = totalBites.split(" ");
      for (int i = 0; i <= indiNum.length - 1; i++)
      {
         try
         {
            if (Integer.parseInt(indiNum[i]) == i + 1)
            {
               sense = true;
            }
            else
            {
               sense = false;
               break;
            }
         }
         catch (NumberFormatException e)
         { ; }
      }
      if (sense == true)
      {
         System.out.println("makes sense");
      }
      else
      {
         System.out.println("something is fishy");
      }
   }
}
