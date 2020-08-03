import java.util.*;
public class beehives
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        String input1 = userInput.nextLine();
        while(!input1.equals("0.0 0"))
        {
            int sour = 0, sweet = 0;
            String[] Input1 = input1.split(" ");
            double distance = Double.parseDouble(Input1[0]);
            int cases = Integer.parseInt(Input1[1]);
            double[] xcord = new double[cases];
            double[] ycord = new double[cases];
            double[] dist = new double[cases];
            String[] sweetSour = new String[cases];
            for(int i = 0; i < cases; i++)
            {
                String location = userInput.nextLine();
                String[] Location = location.split(" ");
                xcord[i] = Double.parseDouble(Location[0]);
                ycord[i] = Double.parseDouble(Location[1]);
            }
            for(int i = 0; i < cases; i++)
            {
                for(int j = 0; j < cases; j++)
                {
                    boolean distSmall = true;
                    if(i != j)
                    {
                        dist[i] = Math.sqrt(Math.pow(xcord[i] - xcord [j], 2) + Math.pow(ycord[i] - ycord[j], 2));
                        distSmall = dist[i] >= distance;
                    }
                    if(distSmall)
                    {
                        sweetSour[i] = "sweet";
                    }
                    else
                    {
                        sweetSour[i] = "sour";
                        break;
                    }
                }
            }
            for(int i = 0; i < cases; i++)
            {
                if(sweetSour[i].equals("sweet"))
                {
                    sweet++;
                }
                else
                {
                    sour++;
                }
            }
            System.out.println(sour + " sour, " + sweet + " sweet");
            input1 = userInput.nextLine();
        }
    }
}