import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> befores = new HashSet<>();

        boolean success = true;

        char pre = words[0].charAt(0);
        int round = 1;
        int player = 0;
        for (String word : words) {
            player++;
            if (befores.contains(word)) {
                success = false;
                break;
            }
            if (pre != word.charAt(0)) {
                success = false;
                break;
            }

            befores.add(word);
            pre = word.charAt(word.length() - 1);

            if (player == n) {
                player = 0;
                round++;
            }
        }

        if (success) {
            return new int[]{0, 0};
        }

        int[] answer = {player, round};
        return answer;
    }
}