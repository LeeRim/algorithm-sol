import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        List<Integer> sub = new ArrayList<>();
        int box = 1;
        for (int i = 0; i < order.length; i++) {
            if (box == order[i]) {
                answer++;
                box++;
                continue;
            }
            if (!sub.isEmpty() && sub.get(sub.size() - 1) == order[i]) {
                answer++;
                sub.remove(sub.size() - 1);
                continue;
            }
            sub.add(box);
            box++;
            if (box > order.length) {
                break;
            }
            i--;
        }

        return answer;
    }
}