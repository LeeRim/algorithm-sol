import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantCount = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantCount.put(want[i], number[i]);
        }

        int answer = 0;
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> buy = new HashMap<>(wantCount);
            for (int j = i; j < i + 10; j++) {
                if (buy.containsKey(discount[j])) {
                    if (buy.get(discount[j]) <= 1) {
                        buy.remove(discount[j]);
                        continue;
                    }
                    buy.replace(discount[j], buy.get(discount[j]) - 1);
                }
            }
            if (buy.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}