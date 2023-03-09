import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : tangerine) {
            if (counts.containsKey(i)) {
                counts.replace(i, counts.get(i) + 1);
                continue;
            }
            counts.put(i, 1);
        }

        List<Integer> sortedCounts = counts.values().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int index = 0;
        for (int i = 0; i < sortedCounts.size(); i++) {
            k -= sortedCounts.get(i);
            if (k <= 0) {
                index = i;
                break;
            }
        }

        return index + 1;
    }
}