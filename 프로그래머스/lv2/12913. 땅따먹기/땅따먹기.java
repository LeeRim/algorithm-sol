import java.util.Arrays;

class Solution {

    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        dp[0] = land[0].clone();
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j == k) {
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k]);
                }
                dp[i][j] += land[i][j];
            }
        }

        return Arrays.stream(dp[land.length - 1]).max().getAsInt();
    }
}