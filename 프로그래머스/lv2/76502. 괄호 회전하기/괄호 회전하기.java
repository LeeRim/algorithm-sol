import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(String s) {
        if (s.length() % 2 != 0) {
            return 0;
        }
        
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
//            System.out.println(sb.toString());
//            System.out.println(isRight(sb.toString()));
            if (isRight(sb.toString())) {
                count++;
            }
            sb.append(s.charAt(i));
            sb.deleteCharAt(0);
        }
//        System.out.println(count);
        return count;
    }

    public boolean isRight(String s) {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('{', '}');
        pairs.put('[', ']');

        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (pairs.containsKey(s.charAt(i))) {
                stack.add(s.charAt(i));
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }

            char pop = stack.get(stack.size() - 1);
            if (pairs.get(pop) == s.charAt(i)) {
                stack.remove(stack.size() - 1);
            } else {
                break;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}