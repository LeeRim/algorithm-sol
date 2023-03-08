import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<Character, Character> pair;

    public int solution(String s) {
        pair = new HashMap<>();
        pair.put(')', '(');
        pair.put('}', '{');
        pair.put(']', '[');

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            if (isRight(s)) {
                count++;
            }
        }

        return count;
    }

    public boolean isRight(String s) {
        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (pair.containsValue(s.charAt(i))) {
                stack.add(s.charAt(i));
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }
            if (pair.get(s.charAt(i)) == stack.get(stack.size() - 1)) {
                stack.remove(stack.size() - 1);
            } else {
                return false;
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}