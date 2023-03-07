import java.io.IOException;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int x = 0;
        for (int i = 3; i < brown; i++) {
            if (((brown + yellow) % i) == 0) {
                x = (brown + yellow) / i;
                if ((i - 2) * (x - 2) == yellow) {
                    answer[0] = x;
                    answer[1] = i;
                    break;
                }
            }
        }

//        System.out.println(Arrays.toString(answer));
        return answer;
    }
}