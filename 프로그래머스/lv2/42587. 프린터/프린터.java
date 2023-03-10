import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        Deque<Integer> waits = new ArrayDeque<>();
        for (int priority : priorities) {
            priorityQueue.add(priority);
            waits.add(priority);
        }

        int answer = 0;
        while (!waits.isEmpty()) {
            if (priorityQueue.peek() == waits.getFirst()) {
                answer++;
                waits.poll();
                priorityQueue.poll();
                if (location == 0) {
                    break;
                }
                location--;
                continue;
            }
            waits.add(waits.poll());
            if (location == 0) {
                location = waits.size() - 1;
                continue;
            }
            location--;
        }
        return answer;
    }
}