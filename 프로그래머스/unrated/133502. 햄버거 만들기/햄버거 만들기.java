import java.util.ArrayList;
import java.util.List;

class Solution {

    public int solution(int[] ingredient) {
        int count = 0;
        List<Integer> stack = new ArrayList<>();
        int lastIndex;
        for (int i = 0; i < ingredient.length; i++) {
            stack.add(ingredient[i]);
            if (stack.size() < 4) {
                continue;
            }
            lastIndex = stack.size() - 1;
            if (stack.get(lastIndex - 3).intValue() == 1
                    && stack.get(lastIndex - 2).intValue() == 2
                    && stack.get(lastIndex - 1).intValue() == 3
                    && stack.get(lastIndex).intValue() == 1) {
                count++;
                for (int j = 0; j < 4; j++) {
                    stack.remove(stack.size() - 1);
                }
            }
        }
//        System.out.println(count);
        return count;
    }
}