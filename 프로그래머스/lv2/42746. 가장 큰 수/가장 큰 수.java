import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
//        System.out.println(Arrays.toString(strs));

        String answer = "";
        if (answer.startsWith("0")) {
            answer = "0";
        }
        for (int i = 0; i < strs.length; i++) {
            if (answer.equals("0")) {
                break;
            }
            answer += strs[i];
        }
        return answer;
    }
}