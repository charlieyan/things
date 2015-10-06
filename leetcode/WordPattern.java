import java.util.*;
import java.io.*;

public class WordPattern {
  public boolean wordPattern(String pattern, String str) {
  	String[] temp = str.split(" ");
  	if (temp.length != pattern.length()) {
  		return false;
  	}
  	HashMap<Character, String> seen = new HashMap<Character, String>();
  	HashMap<String, Character> seen2 = new HashMap<String, Character>();

  	for (int i = 0; i < temp.length; i++) {
  		String word = temp[i];
  		Character patternToken = pattern.charAt(i);

  		String storedWord = seen.get(patternToken);
  		Character storedCharacter = seen2.get(word);
			
		if (storedWord == null) {
			seen.put(patternToken, word);
		}
		else {
			if (!storedWord.equals(word)) {
				return false;
			}
		}

		if (storedCharacter == null) {
			seen2.put(word, patternToken);
		}
		else {
			if (!storedCharacter.equals(patternToken)) {
				return false;
			}
		}
  	}
  	return true;
  }

  public static void main(String[] args) {
  	WordPattern w = new WordPattern();
  	System.out.println(w.wordPattern("abba", "charlie alena alena charlie"));
   	System.out.println(w.wordPattern("aaaa", "charlie alena alena charlie"));
  	System.out.println(w.wordPattern("abba", "alena alena alena alena"));
  }
}