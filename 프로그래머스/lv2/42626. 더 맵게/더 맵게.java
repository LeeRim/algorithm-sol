import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int k) {
        PriorityQueue<Integer> scovilles = new PriorityQueue<>();
        for (int i : scoville) {
            scovilles.add(i);
        }

        int answer = 0;
        while (scovilles.peek() < k) {
            if (scovilles.size() < 2) {
                return -1;
            }
            scovilles.add(scovilles.poll() + scovilles.poll() * 2);
            answer++;
        }

        return answer;
    }
}