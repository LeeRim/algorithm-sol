import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int day = 0;
        int[] days = new int[speeds.length];
        for (int i=0; i<speeds.length; i++) {
            day = (100 - progresses[i]) / speeds[i];
            if(((100 - progresses[i]) % speeds[i]) != 0){
                day++;
            }
            days[i] = day;
        }

        int max = days[0];
        int doneCount = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < days.length; i++) {
            if (max >= days[i]) {
                doneCount++;
            } else {
                result.add(doneCount);
                max = days[i];
                doneCount = 1;
            }
            if (i == days.length - 1) {
                result.add(doneCount);
            }
        }

        answer = result.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}