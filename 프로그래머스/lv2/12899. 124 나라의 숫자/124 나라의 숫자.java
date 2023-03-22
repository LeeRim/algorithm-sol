class Solution {
    public String solution(int n) {
        char[] nums = {'4', '1', '2'};

        StringBuilder sb = new StringBuilder();
        int mod;
        while (n > 0) {
            mod = n % 3;
            n /= 3;
            if (mod == 0) {
                n--;
            }
            sb.append(nums[mod]);
        }

        return sb.reverse().toString();
    }
}