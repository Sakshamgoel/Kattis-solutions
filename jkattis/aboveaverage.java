import java.util.*;
import java.text.DecimalFormat;
public class aboveaverage
{
    public static void main(String[] args)
    {
        DecimalFormat df = new DecimalFormat("0.000");
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i = 0; i < cases; i++)
        {
            double abovePercent = 0;
            int above = 0;
            double total = 0.0;
            int students = scan.nextInt();
            double[] marks = new double[students];
            for(int j = 0; j < students; j++)
            {
                marks[j] = scan.nextInt();
                total += marks[j];
            }
            double average = total/students;
            for(int j = 0; j < students; j++)
            {
                if(marks[j] > average)
                {
                    above++;
                }
            }
            double a = above;
            double s = students;
            abovePercent = (a*100)/s;
            //System.out.println(abovePercent);
            System.out.println(df.format(abovePercent) + "%");
        }
    }
}