import java.util.*;
public class asciiaddition
{
    public static void main(String[] args)
    {
        int a = 0, b = 0, valPlus = 0;
        Scanner in = new Scanner(System.in);
        String[] totalInput = new String[7];
        HashMap<String, Integer> data = new HashMap<String, Integer>();
        HashMap<Integer, String> reverseData = new HashMap<Integer, String>();
        String zero = "xxxxxx...xx...xx...xx...xx...xxxxxx"; data.put(zero, 0); reverseData.put(0,zero);
        String one = "....x....x....x....x....x....x....x"; data.put(one, 1); reverseData.put(1,one);
        String two = "xxxxx....x....xxxxxxx....x....xxxxx"; data.put(two, 2); reverseData.put(2,two);
        String three = "xxxxx....x....xxxxxx....x....xxxxxx"; data.put(three, 3); reverseData.put(3,three);
        String four = "x...xx...xx...xxxxxx....x....x....x"; data.put(four, 4); reverseData.put(4,four);
        String five = "xxxxxx....x....xxxxx....x....xxxxxx"; data.put(five, 5); reverseData.put(5,five);
        String six = "xxxxxx....x....xxxxxx...xx...xxxxxx"; data.put(six, 6); reverseData.put(6,six);
        String seven = "xxxxx....x....x....x....x....x....x"; data.put(seven, 7); reverseData.put(7,seven);
        String eight = "xxxxxx...xx...xxxxxxx...xx...xxxxxx"; data.put(eight, 8); reverseData.put(8,eight);
        String nine = "xxxxxx...xx...xxxxxx....x....xxxxxx"; data.put(nine, 9); reverseData.put(9,nine);
        String plus = ".......x....x..xxxxx..x....x.......";
        for(int i = 0; i < 7; i++)
        {
            totalInput[i] = in.nextLine();
        }
        int totalNum = totalInput[1].length()/6 + 1;
        String[] Input = new String[totalNum];
        for(int i = 0; i < totalNum; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                Input[i] += totalInput[j].substring(i*6, (i+1)*6 - 1);
            }
            Input[i] = Input[i].substring(4);
            if(Input[i].equals(plus))
            {
                valPlus = i;
            }
        }
        for(int i = 0; i < valPlus; i++)
        {
            a = a*10 + data.get(Input[i]);
        }
        for(int i = valPlus+1; i < totalNum; i++)
        {
            b = b*10 + data.get(Input[i]);
        }
        int sum = a + b;
        int lengths = (int)(Math.log10(sum)+1);
        Integer[] Sum = new Integer[lengths];
        for(int i = 0; i < lengths; i++)
        {
            Sum[i] = sum%10;
            sum = sum/10;
        }
        Collections.reverse(Arrays.asList(Sum));
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < lengths; j++)
            {
                System.out.print(reverseData.get(Sum[j]).substring(i*5, (i+1)*5));
                if(j < lengths - 1)
                {
                    System.out.print(".");
                }
            }
            System.out.print("\n");
        }
    }
}