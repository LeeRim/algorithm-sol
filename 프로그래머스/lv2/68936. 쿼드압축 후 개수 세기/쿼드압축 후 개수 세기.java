class Solution {
    public int[] solution(int[][] arr) {
        return press(arr, 0, arr.length, 0, arr.length);
    }

    public int[] press(int[][] arr, int x1, int x2, int y1, int y2) {
        int count = 0;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (arr[i][j] == 0) {
                    count++;
                }
            }
        }

        int total = (int) Math.pow(x2 - x1, 2);
        if (count == 0) {
            return new int[]{0, 1};
        }
        if (count == total) {
            return new int[]{1, 0};
        }

        int half = (x2 - x1) / 2;
        int[] re1 = press(arr, x1, x2 - half, y1, y2 - half);
        int[] re2 = press(arr, x1 + half, x2, y1, y2 - half);
        int[] re3 = press(arr, x1, x2 - half, y1 + half, y2);
        int[] re4 = press(arr, x1 + half, x2, y1 + half, y2);

        return new int[]{re1[0] + re2[0] + re3[0] + re4[0], re1[1] + re2[1] + re3[1] + re4[1]};
    }
}