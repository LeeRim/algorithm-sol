import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String s) {

        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(s.charAt(i));
                continue;
            }
            if (stack.get(stack.size() - 1) == s.charAt(i)) {
                stack.remove(stack.size() - 1);
            } else {
                stack.add(s.charAt(i));
            }
        }

        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}