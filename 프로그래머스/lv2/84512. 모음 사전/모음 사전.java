import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    List<String> words;
    public int solution(String word) {
        words = new ArrayList<>();
        String[] vowels = {"A", "E", "I", "O", "U"};
        makeWord(vowels, new StringBuilder(), 0);
        Collections.sort(words);
        return words.indexOf(word);
    }

    public void makeWord(String[] vowels, StringBuilder sb, int count) {
        if (count > 5) {
            return;
        }
        words.add(sb.toString());
        for (String vowel : vowels) {
            sb.append(vowel);
            makeWord(vowels, new StringBuilder(sb), count + 1);
            if (!vowel.equals("")) {
                sb.delete(sb.length() - 1, sb.length());
            }
        }
    }
}