import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] result = new int[2];

        Set<String> answer = new HashSet<>();

        int index = 0;
        for (int i = 0; i < words.length; i++) {
            if (!answer.add(words[i])) {
                index = i;
                break;
            }
            if (i > 0 && words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                index = i;
                break;
            }
        }
        index++;

        if (words.length != answer.size()) {
            if (index % n == 0) {
                result[0] = n;
                result[1] = index / n;
            } else {
                result[0] = index % n;
                result[1] = index / n + 1;
            }
        }

        return result;
    }
}