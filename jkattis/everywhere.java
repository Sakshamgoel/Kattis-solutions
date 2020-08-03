import java.util.*;
public class everywhere
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        int numInput1 = 0;
        numInput1 = Integer.parseInt(userInput.nextLine());
        int[] numInput2 = new int[numInput1];
        for(int i = 0; i < numInput1; i++)
        {
            numInput2[i] = Integer.parseInt(userInput.nextLine());
            String[] places = new String[numInput2[i]];
            for(int j = 0; j < numInput2[i]; j++)
            {
                places[j] = userInput.nextLine();
            }
            Set<String> place = new HashSet<String>(Arrays.asList(places));
            int size = place.size();
            System.out.println(size);
        }
    }
}
