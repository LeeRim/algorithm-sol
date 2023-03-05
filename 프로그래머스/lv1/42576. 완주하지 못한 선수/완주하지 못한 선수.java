import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> counts = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            if (counts.containsKey(participant[i])) {
                counts.replace(participant[i], counts.get(participant[i]) + 1);
                continue;
            }
            counts.put(participant[i], 1);
        }

        for (int i = 0; i < completion.length; i++) {
            counts.replace(completion[i], counts.get(completion[i]) - 1);
            if (counts.get(completion[i]) == 0) {
                counts.remove(completion[i]);
            }
        }

        return counts.keySet().stream().findFirst().get();
    }
}