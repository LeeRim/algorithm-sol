import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int m, int[] score) {
        List<Integer> scores = Arrays.stream(score)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int sum = 0;
        for (int i = m - 1; i < score.length; i += m) {
            sum += scores.get(i);
        }

        return sum * m;
    }
}