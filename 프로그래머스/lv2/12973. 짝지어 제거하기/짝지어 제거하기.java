import java.util.ArrayList;
import java.util.List;

class Solution
{
    public int solution(String s) {
        int answer = 0;

        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                if (stack.get(stack.size() - 1) == s.charAt(i)) {
                    stack.remove(stack.size() - 1);
                    continue;
                }
            }
            stack.add(s.charAt(i));
        }

//        System.out.println(stack);
        if (stack.size() == 0) {
            answer = 1;
        }
        return answer;
    }
}