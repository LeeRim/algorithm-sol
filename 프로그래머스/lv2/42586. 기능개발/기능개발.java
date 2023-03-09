import java.util.ArrayList;
import java.util.Arrays;

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

        System.out.println(Arrays.toString(days));

        int max = -1;
        int re = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i=0; i<days.length; i++) {
            if (max >= days[i]) {
                re++;
            } else {
                max = days[i];
                if (re != 0) result.add(re);
                re = 1;
            }
            if (i == days.length-1){
                result.add(re);
            }
        }

        answer = result.stream().mapToInt(i -> i).toArray();

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}