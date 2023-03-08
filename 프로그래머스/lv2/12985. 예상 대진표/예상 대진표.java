class Solution {
    public int solution(int n, int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int count = 1;
        while (b - a > 1 || a % 2 == 0) {
            if (a % 2 != 0) {
                a++;
            }
            if (b % 2 != 0) {
                b++;
            }
            a /= 2;
            b /= 2;
            count++;
        }

        return count;
    }
}