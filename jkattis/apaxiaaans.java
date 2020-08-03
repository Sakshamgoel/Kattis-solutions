import java.util.*;
public class apaxiaaans {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String name = userInput.nextLine();
        String name2 = "";
        try {
        for(int i = 0; i < name.length(); i++) {
            if(name.charAt(i) != name.charAt(i+1)) {
                name2 += name.charAt(i);
            }
        } } catch(StringIndexOutOfBoundsException e) {;}
        name2 += name.charAt(name.length()-1);
        System.out.println(name2);
    }
}