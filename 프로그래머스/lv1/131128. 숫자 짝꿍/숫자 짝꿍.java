class Solution {
    public String solution(String X, String Y) {

        int[] xNums = countNum(X);
        int[] yNums = countNum(Y);

        int[] commons = new int[10];
        for (int i = 0; i < 10; i++) {
            commons[i] = Math.min(xNums[i], yNums[i]);
        }
//        System.out.println(Arrays.toString(commons));

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < commons[i]; j++) {
                sb.append(i);
            }
        }
//        System.out.println(sb);

        if (sb.length() == 0) {
            return "-1";
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }

    public int[] countNum(String str) {
        int[] nums = new int[10];

        int index;
        for (int i = 0; i < str.length(); i++) {
            index = str.charAt(i) - '0';
            nums[index]++;
        }

        return nums;
    }
}