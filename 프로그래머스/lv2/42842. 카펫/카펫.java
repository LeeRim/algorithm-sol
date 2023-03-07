class Solution {
    public int[] solution(int brown, int yellow) {
        int x = 0;
        int y = 0;

        int half = brown / 2 + 1;
        for (int i = 3; i <= brown / 2; i++) {
            x = half - i + 1;
            if ((x - 2) * (i - 2) == yellow) {
                y = i;
                break;
            }
        }

        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
        }
        int[] answer = {x, y};
        return answer;
    }
}