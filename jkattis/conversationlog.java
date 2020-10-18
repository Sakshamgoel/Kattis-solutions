import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;

public class conversationlog {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int cases = Integer.parseInt(in.nextLine());

		//HashSet<String> wordList = new HashSet<String>();

		ArrayList<String> people = new ArrayList<String>();

		HashMap<String, ArrayList<String>> personToWords = new HashMap<String, ArrayList<String>>();

		HashMap<String, HashSet<String>> personToSpecificWords = new HashMap<String, HashSet<String>>();

		HashSet<String> finalWordList = new HashSet<String>();


		for(int i = 0; i < cases; i++) {
			String[] input = in.nextLine().split(" ");

			String person = input[0];

			if(!people.contains(person)) {
				people.add(person);
				personToWords.put(person, new ArrayList<String>());
				personToSpecificWords.put(person, new HashSet<String>());
			}

			for(int j = 1; j < input.length; j++) {
				personToWords.get(person).add(input[j]);
				personToSpecificWords.get(person).add(input[j]);
			}

		}

		finalWordList = new HashSet<String>(personToSpecificWords.get(people.get(0)));

		for(String p : personToSpecificWords.get(people.get(0))) {
			for(int j = 1; j < people.size(); j++) {
				if(!personToSpecificWords.get(people.get(j)).contains(p)) {
					finalWordList.remove(p);
					break;
				}
			}
		}

		HashMap<String, Integer> wordToFrequency = new HashMap<String, Integer>();

		for(String s : finalWordList) {
			wordToFrequency.put(s, 0);
			for(int j = 0; j < people.size(); j++) {
				for(String p : personToWords.get(people.get(j))) {
					if(s.equals(p)) {
						wordToFrequency.put(s, wordToFrequency.get(s) + 1);
					}
				}
			}
		}

		ArrayList<Tuple> finalList = new ArrayList<Tuple>();

		for(String s : finalWordList) {
			finalList.add(new Tuple(s, wordToFrequency.get(s)));
		}

		Collections.sort(finalList);

		for(Tuple t : finalList) {
			System.out.println(t.word);
		}
		if(finalList.size() == 0) {
			System.out.println("ALL CLEAR");
		}
	}
}

class Tuple implements Comparable<Tuple> {

	String word;
	int frequency;

	public Tuple(String wordIn, int frequencyIn) {
		word = wordIn;
		frequency = frequencyIn;
	}

	public int compareTo(Tuple t) {
		if(t.frequency == this.frequency) {
			return this.word.compareTo(t.word);
		}
		return t.frequency - this.frequency;
	}
}