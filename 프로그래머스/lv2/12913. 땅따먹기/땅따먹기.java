class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        for (int i = 0; i < land.length; i++) {
            dp[i] = land[i].clone();
        }

        int max;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < 4; j++) {
                max = -1;
                for (int k = 0; k < 4; k++) {
                    if (j == k) {
                        continue;
                    }
                    max = Math.max(max, dp[i - 1][k]);
                }
                dp[i][j] += max;
            }
        }

        int answer = -1;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[dp.length - 1][i]);
        }
        return answer;
    }
}