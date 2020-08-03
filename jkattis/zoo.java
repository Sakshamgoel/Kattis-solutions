import java.util.*;
public class zoo
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        int inputCase = Integer.parseInt(userInput.nextLine());
        int list = 1;
        while(inputCase !=0)
        {
            String[] animals = new String[inputCase];
            String nameStore = "";
            for(int i = 0; i < inputCase; i++)
            {
                animals[i] = userInput.nextLine();
                animals[i] = animals[i].toLowerCase().substring(animals[i].lastIndexOf(" ") + 1);
            }
            //Arrays.sort(animals);
            Set<String> animalSet = new HashSet<String>(Arrays.asList(animals));
            String[] SetToArray = new String[animalSet.size()];
            SetToArray = animalSet.toArray(SetToArray);
            int[] numOfAnimals = new int[SetToArray.length + 1];
            int count = 0;
            Arrays.sort(SetToArray);
            for( int i = 0; i < SetToArray.length; i++)
            {
                for(int j = 0; j < animals.length; j++)
                {
                    if(SetToArray[i].equals(animals[j]))
                    {
                        count++;
                    }
                }
                numOfAnimals[i] = count;
                count = 0;
            }
            System.out.println("List " + list + ":");
            for(int i = 0; i < SetToArray.length; i++)
            {
                System.out.println(SetToArray[i] + " | " + numOfAnimals[i]);
            }
            //System.out.println(animalSet);
            inputCase = Integer.parseInt(userInput.nextLine());
            list++;
        }
    }
}

