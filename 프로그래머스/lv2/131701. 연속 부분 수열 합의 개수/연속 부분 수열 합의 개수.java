import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();
        for (int element : elements) {
            sums.add(element);
        }
        int[][] dp = new int[elements.length][elements.length];
        dp[0] = elements.clone();
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i + j >= dp[0].length) {
                    dp[i][j] = dp[i - 1][j] + dp[0][i + j - dp[0].length];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[0][i + j];
                }
                sums.add(dp[i][j]);
            }
        }
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
//        System.out.println(sums);
//        System.out.println(sums.size());
        return sums.size();
    }
}