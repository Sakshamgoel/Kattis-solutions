import java.util.Scanner;
public class datum
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int date = scan.nextInt();
        int month = scan.nextInt();
        while(month != 1)
        {
            if(month == 2 || month == 4 || month == 6 || month == 8 || month == 9 || month == 11)
            {
                date += 31;
                month = month - 1;
            }
            if(month == 3)
            {
                date += 28;
                month = month - 1;
            }
            if(month == 5 || month == 7 || month == 10 || month == 12)
            {
                date += 30;
                month = month - 1;
            }
            //System.out.println(date);
        }
        int day = date % 7;
        switch(day)
        {
            case 0:
            System.out.println("Wednesday");
            break;
            case 1:
            System.out.println("Thursday");
            break;
            case 2:
            System.out.println("Friday");
            break;
            case 3:
            System.out.println("Saturday");
            break;
            case 4:
            System.out.println("Sunday");
            break;
            case 5:
            System.out.println("Monday");
            break;
            case 6:
            System.out.println("Tuesday");
            break;
            default:
            ;
        }
    }   
}