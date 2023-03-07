import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String s) {
        List<Integer> countZero = new ArrayList<>();

        int count;
        while (!s.equals("1")) {
            count = getCount0(s);
            countZero.add(count);
            s = change(s.length() - count);
        }

        int[] answer = {countZero.size(),
                countZero.stream()
                        .mapToInt(i -> i)
                        .sum()};
        return answer;
    }

    public int getCount0(String s) {
        return (int) s.chars()
                .filter(c -> c == '0')
                .count();
    }

    public String change(int count) {
        return Integer.toBinaryString(count);
    }
}