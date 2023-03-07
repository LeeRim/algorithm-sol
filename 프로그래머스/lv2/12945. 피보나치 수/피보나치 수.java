class Solution {
    public int solution(int n) {

        long n1 = 0;
        long n2 = 1;
        long temp;
        for (int i = 2; i <= n; i++) {
            temp = n2;
            n2 = (n1 + n2) % 1234567;
            n1 = temp;
        }

        return (int) n2;
    }
}