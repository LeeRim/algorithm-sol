class Solution {
    public int solution(String s) {
        int answer = 1;

        char start = s.charAt(0);
        int startCount = 1;
        int noneCount = 0;
        for (int i = 1; i < s.length(); i++) {
            if (startCount == noneCount) {
                startCount = 1;
                noneCount = 0;
                start = s.charAt(i);
                answer++;
                continue;
            }
            if (start == s.charAt(i)) {
                startCount++;
            } else {
                noneCount++;
            }
        }

//        System.out.println(answer);
        return answer;
    }
}