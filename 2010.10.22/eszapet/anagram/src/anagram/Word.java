package anagram;

import java.util.Arrays;

public class Word {
	private String word;
	private int length;
	private String characters;
	
	public Word(String word) {
		this.word = word;
		this.length = word.length();
		char[] carr = word.toCharArray();
		Arrays.sort(carr);
		this.characters = String.valueOf(carr);
	}
	
	//isAnagram
	public boolean isAnagram(Word word) {
		System.err.println(getCharacters());
		System.err.println(word.getCharacters());
		return getCharacters().equals(word.getCharacters());
	}

	public String getWord() {
		return word;
	}

	public int getLength() {
		return length;
	}

	public String getCharacters() {
		return characters;
	}

	@Override
	public String toString() {
		return "Word [word=" + word + ", length=" + length + ", characters=" + characters + "]";
	}
	
}
