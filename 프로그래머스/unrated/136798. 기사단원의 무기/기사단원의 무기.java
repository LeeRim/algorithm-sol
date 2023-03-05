class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;
        for (int i = 2; i <= number; i++) {
            int count = 2;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    if (j == Math.sqrt(i)) {
                        count++;
                    } else {
                        count += 2;
                    }
                }
            }
            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }
//        System.out.println(answer);
        return answer;
    }
}