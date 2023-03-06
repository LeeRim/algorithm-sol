import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        List<Integer> iarr = Arrays.stream(arr).map(str -> Integer.valueOf(str)).sorted().collect(Collectors.toList());
        int max = iarr.get(iarr.size()-1);
        int min = iarr.get(0);
        answer = String.valueOf(min) + " " + String.valueOf(max);
        // System.out.println(answer);
        return answer;
    }
}