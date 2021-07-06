import java.util.*;
public class whatDoesTheFoxSay
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        int cases = Integer.parseInt(userInput.nextLine());
        for(int x = 0;x < cases; x++)
        {
            String inputSounds = userInput.nextLine();
            inputSounds = " " + inputSounds;
            String arrStore = "";
            String[] animalSounds = new String[100];
            int j = 0;
            do
            {
                animalSounds[j] = userInput.nextLine();
                j++;
            }
            while(!animalSounds[j - 1].equals("what does the fox say?"));
            try
            {
                for(int i = 0; i < animalSounds.length-1; i++)
                {
                    arrStore += animalSounds[i].substring(animalSounds[i].lastIndexOf(" ") + 1);
                    arrStore += " ";
                }
            }catch (NullPointerException e) {;}
            arrStore = arrStore.substring(0, arrStore.length() - 6);
            String[] totalSounds = arrStore.split(" ");
            for(int i = 0; i < totalSounds.length; i++)
            {
                if(inputSounds.contains(" " + totalSounds[i]))
                {
                    inputSounds = inputSounds.replaceAll(" " + totalSounds[i], "");
                }
            }
            String[] foxSounds = inputSounds.split(" ");
            String done = "";
            for(int i = 0; i < foxSounds.length; i++)
            {
                done = done + foxSounds[i] + " ";
            }
            System.out.println(done.trim());
        }
    }
        
}
