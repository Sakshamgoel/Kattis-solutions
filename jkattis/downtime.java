import java.util.Scanner;

public class downtime {
    
    static int requests;
    static int maxPerServer;

    static int[] startTimes;
    static int[] endTimes;
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        requests = in.nextInt();
        maxPerServer = in.nextInt();

        startTimes = new int[requests];
        endTimes = new int[requests];

        for(int i = 0; i < requests; i++) {
            startTimes[i] = in.nextInt();
            endTimes[i] = startTimes[i] + 1000;
        }

        int startCount = 0;
        int endCount = 0;

        int maxPeople = 0;
        int maxMaxPeople = 0;

        while(startCount < requests) {

            if(startTimes[startCount] < endTimes[endCount]) {
                maxPeople++;
                startCount++;
                maxMaxPeople = Math.max(maxPeople, maxMaxPeople);
            } else {
                maxPeople--;
                endCount++;
            }
        }
        if(maxMaxPeople % maxPerServer == 0) {
            maxMaxPeople = maxMaxPeople / maxPerServer;
        } else {
            maxMaxPeople = (int)(maxMaxPeople / maxPerServer) + 1;
        }
        System.out.println(maxMaxPeople);
    }
}