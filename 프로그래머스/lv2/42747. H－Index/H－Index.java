import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int count = 0;
        for (int i = 0; i < citations.length; i++) {
            count = citations.length - i;
            if (citations[i] >= count) {
                answer = count;
                break;
            }
        }
        // System.out.println(answer);
        return answer;
    }
}