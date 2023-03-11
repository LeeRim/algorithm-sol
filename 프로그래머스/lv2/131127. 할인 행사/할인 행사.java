import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int remain = 0;
        Map<String, Integer> wants = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wants.put(want[i], number[i]);
            remain += number[i];
        }

        int answer = 0;
        for (int i = 0; i < discount.length; i++) {
            if (wants.containsKey(discount[i])) {
                if (wants.get(discount[i]) > 0) {
                    remain--;
                }
                wants.replace(discount[i], wants.get(discount[i]) - 1);
            }

            if (i >= 10) {
                if (wants.containsKey(discount[i - 10])) {
                    wants.replace(discount[i - 10], wants.get(discount[i - 10]) + 1);
                    if (wants.get(discount[i - 10]) > 0) {
                        remain++;
                    }
                }
            }

            if (remain <= 0) {
                answer++;
            }
        }

        return answer;
    }
}