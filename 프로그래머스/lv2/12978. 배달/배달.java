import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int N, int[][] road, int K) {

        int[] mins = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            mins[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> minDistance = new PriorityQueue<>(Comparator.comparingInt(d -> d[1]));
        for (int[] r : road) {
            if (r[0] == 1) {
                minDistance.add(new int[]{r[1], r[2]});
                continue;
            }
            if (r[1] == 1) {
                minDistance.add(new int[]{r[0], r[2]});
            }
        }

        int[] now, next;
        while (!minDistance.isEmpty()) {
            now = minDistance.poll();

            if (now[1] >= mins[now[0]]) {
                continue;
            }

            mins[now[0]] = now[1];

            for (int[] r : road) {
                if (r[0] == now[0]) {
                    next = new int[]{r[1], r[2]};
                } else if (r[1] == now[0]) {
                    next = new int[]{r[0], r[2]};
                } else {
                    continue;
                }

                next[1] += now[1];
                if (next[1] < mins[next[0]]) {
                    minDistance.add(next);
                }
            }
        }

        int answer = 1;
        for (int i = 2; i <= N; i++) {
            if (mins[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}