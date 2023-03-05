import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] results = new int[score.length];

        PriorityQueue<Integer> kList = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            if(i >= score.length){
                break;
            }
            kList.add(score[i]);
            results[i] = kList.peek();
        }

        for (int i = k; i < score.length; i++) {
            if (kList.peek() < score[i]) {
                kList.poll();
                kList.add(score[i]);
            }
            results[i] = kList.peek();
        }

        return results;
    }
}