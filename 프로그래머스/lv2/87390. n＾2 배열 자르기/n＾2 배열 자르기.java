class Solution {
    public int[] solution(int n, long left, long right) {
        long m = (long) n;
        int[] arr = new int[(int) (right - left) + 1];

        for (long i = left; i <= right; i++) {
            arr[(int) (i - left)] = (int) Math.max(i / m + 1, i % m + 1);
        }

        return arr;
    }
}