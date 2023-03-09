import java.util.*;

class Solution {

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : tangerine) {
            if (!counts.containsKey(i)) {
                counts.put(i, 1);
                continue;
            }
            counts.replace(i, counts.get(i) + 1);
        }

        List<Integer> sizes = new ArrayList<>(counts.keySet());
        sizes.sort((o1, o2) -> counts.get(o2) - counts.get(o1));

        int typeCount = 0;
        for (Integer size : sizes) {
            if (k <= 0) {
                break;
            }
            k -= counts.get(size);
            typeCount++;
        }

        return typeCount;
    }
}