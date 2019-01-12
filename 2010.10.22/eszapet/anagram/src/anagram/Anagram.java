package anagram;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Anagram {

	private static Dictionary dictionary = new Dictionary();

	public static void main(String[] args) throws Exception {
		// 2//
		System.out.println(dictionary.getWordList().size());

		// 1//
		System.out.printf("unique caracters are: %d", dictionary.getUniqueCharacters());
		String answer = dictionary.waitUserInput("Adja meg a szoveget:");
		char[] ca = answer.toCharArray();
		Set<Character> cSet = new HashSet();
		StringBuilder sb = new StringBuilder();
		for (char c : ca) {
			cSet.add(c);
		}
		for (char c : cSet) {
			sb.append(c);
		}
		System.out.printf("A szovegben %d kulonbozo karakte talalhato, ezek: %s", cSet.size(), sb);

		// 3//
		BufferedWriter bw = null;
		bw = new BufferedWriter(new FileWriter(new File("resources/abc.txt")));
		for (Word w : dictionary.getWordList()) {
			char[] c = w.getCharacters().toCharArray();
			Arrays.sort(c);
			bw.write(c);
			bw.write("\n");
		}
		bw.close();

		// 4//
		answer = dictionary.waitUserInput("Kerek ket szot, irja be kerem az elsot:");
		boolean isOK = new Word(answer.trim())
				.isAnagram(new Word(dictionary.waitUserInput("Most pedig a masodikat :")));
		System.out.printf("az alabbi szavak: %s\n", isOK ? "Anagramma" : "Sajnos nem Anagramma");

		// 5//
		answer = dictionary.waitUserInput("Kerek egy szot ismet:");
		boolean noMatch = true;
		int maxLength = 0;
		for (Word w : dictionary.getWordList()) {
			if (w.getCharacters().equals(new Word(answer).getCharacters())) {
				noMatch = true;
				System.out.println(w.getWord());
			}

			if (w.getLength() > maxLength) {
				maxLength = w.getLength();
			}
		}
		if (noMatch) {
			System.out.println("Nincs a szotarban anagramma");
		}
		// 6//
		for (Word w : dictionary.getWordList()) {
			if (w.getLength() == maxLength) {
				System.out.println(w.getWord());
			}
		}
		// 7//
		List<Word> sortedDictionary = dictionary.getWordList();
		Collections.sort(sortedDictionary, (c, d) -> {
			Word o1 = (Word) c;
			Word o2 = (Word) d;

			return o1.getLength() - o2.getLength();
		});

		List<StringBuilder> words = new ArrayList<>();
		StringBuilder line;
		for (int i = 4; i <= maxLength; i++) {
			Word previousWord = sortedDictionary.get(0);
			sortedDictionary.remove(previousWord);
			line = new StringBuilder(previousWord.getWord());
			int a = 0;
			for (int ii = 0; ii < sortedDictionary.size(); ii++) {
				
				if(a + 1 > sortedDictionary.size()-1) {
					a = 0;
					continue;
				}

				if (sortedDictionary.get(a).getLength() == i) {
					Word word = sortedDictionary.get(a);
					if (word.getCharacters().equals(previousWord.getCharacters())) {
						line.append(" " + word.getWord());
						previousWord = word;
						sortedDictionary.remove(word);
						a = 0;
					} else {
						if(a + 1 > sortedDictionary.size()-1) {
							a = 0;
							continue;
						}else {
						a += 1;}
					}
				} else {
					words.add(line);
					line = new StringBuilder(previousWord.getWord());
				}
			}
		}

		System.out.println("THE LAST ONE:");
		for (StringBuilder stringBuilder : words) {
			System.out.println("line: " + stringBuilder.toString());
		}
	}

}
