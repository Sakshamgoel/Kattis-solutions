import java.util.*;
public class princesspeach
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int totalObs = in.nextInt();
        int marioSays = in.nextInt();
        HashSet<Integer> mario = new HashSet<Integer>();
        for(int i = 0; i < marioSays; i++)
        {
            mario.add(in.nextInt());
        }
        for(int i = 0; i < totalObs; i++)
        {
            if(!mario.contains(i))
            {
                System.out.println(i);
            }
        }
        System.out.println("Mario got " + mario.size() + " of the dangerous obstacles.");
    }
}
