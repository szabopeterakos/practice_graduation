package anagram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Dictionary {

	private List<Word> wordList = new ArrayList<>();
	private Set<Character> uniqueCharacters = new HashSet();

	public Dictionary() {
		initFromFile("resources/szotar.txt");
	}

	private void initFromFile(String file){
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(file)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;
		try {
			while ((line = br.readLine()) != null) {
				Word currentWord = new Word(line);
				wordList.add(currentWord);
				doFilterCharacters(currentWord.getWord());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String waitUserInput(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n"+message);
		String answer = sc.nextLine();
		return answer;
	}
	
	private void doFilterCharacters(String word) {
		char[] wordArr= word.toCharArray();
		for (char c : wordArr) {
			uniqueCharacters.add(c);
		}
	}

	public List<Word> getWordList() {
		return wordList;
	}

	public int getUniqueCharacters() {
		return uniqueCharacters.size();
	}

	@Override
	public String toString() {
		return "Dictionary [wordList=" + wordList + "]";
	}
	
	

}
