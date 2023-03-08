import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        Deque<Integer> weights = new ArrayDeque<>();
        for (int person : people) {
            weights.add(person);
        }

        int count = 0;
        int first = weights.getFirst();
        int last;
        while (!weights.isEmpty()) {
            count++;
            last = weights.pollLast();
            if (last + first <= limit) {
                weights.poll();
                if (!weights.isEmpty()) {
                    first = weights.getFirst();
                }
            }
        }

        return count;
    }
}