import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean solution(String s) {
        List<Character> opens = new ArrayList<>();

        boolean answer = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                opens.add('(');
                continue;
            }
            if (opens.isEmpty()) {
                answer = false;
                break;
            }
            opens.remove(opens.size() - 1);
        }

        if (!opens.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}