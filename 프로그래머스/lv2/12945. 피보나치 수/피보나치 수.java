class Solution {
    public int solution(int n) {
        int n1 = 1;
        int n2 = 0;
        int temp = 0;
        for (int i = 2; i < n; i++) {
            temp = n1;
            n1 = ((n1 % 1234567) + (n2 % 1234567)) % 1234567;
            n2 = temp;
        }
        return (n1 + n2) % 1234567;
    }
}