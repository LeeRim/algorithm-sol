class Solution {
    public String solution(String X, String Y) {
        String answer = "";

        int[] xCount = countNum(X);
        int[] yCount = countNum(Y);

        int[] and = new int[10];
        for (int i = 0; i < 10; i++) {
            and[i] = Math.min(xCount[i], yCount[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (and[i] == 0) {
                continue;
            }
            for (int j = 0; j < and[i]; j++) {
                sb.append(i);
            }
        }

        if (sb.length() == 0) {
            return "-1";
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }

    public int[] countNum(String num) {
        int[] counts = new int[10];

        int n;
        for (int i = 0; i < num.length(); i++) {
            n = Character.getNumericValue(num.charAt(i));
            counts[n]++;
        }

        return counts;
    }
}