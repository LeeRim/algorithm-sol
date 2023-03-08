class Solution {

    public int solution(int[] arr) {

        int pre = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pre = lcm(pre, arr[i]);
        }

        return pre;
    }

    public int gcd(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if(b % a == 0) {
            return a;
        }
        return gcd(b % a, a);
    }

    public int lcm(int a, int b){
        return a * b / gcd(a, b);
    }
}