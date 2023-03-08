class Solution {
    public long solution(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        long answer = dp[n];
//        System.out.println(answer);
        return answer;
    }
}