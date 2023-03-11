import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> scovilles = new PriorityQueue<Integer>();
        for (int s : scoville) {
            scovilles.add(Integer.valueOf(s));
        }

        int newsco = 0;
        while (scovilles.size() > 1) {
            if (scovilles.peek() < K) {
                newsco = scovilles.poll() + (scovilles.poll() * 2);
                if (newsco < K && scovilles.isEmpty()) {
                    answer = -1;
                    break;
                }
                answer++;
                scovilles.add(newsco);
            } else {
                break;
            }
        }
        return answer;
    }
}