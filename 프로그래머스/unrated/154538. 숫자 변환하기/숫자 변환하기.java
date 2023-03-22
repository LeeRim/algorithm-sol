class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];

        for (int i = x + 1; i <= y; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        int next;
        for (int i = x; i < y; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            for (int j = 3; j > 0; j--) {
                if (j == 1) {
                    next = i + n;
                } else {
                    next = i * j;
                }

                if (next > y) {
                    continue;
                }
                dp[next] = Math.min(dp[next], dp[i] + 1);
            }
        }

        if (dp[y] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[y];
    }
}