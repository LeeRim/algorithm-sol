import java.util.Arrays;

class Solution {
    public int[] solution(int[][] arr) {
        int[] counts = new int[2];
        compress(arr, counts);
        return counts;
    }

    public void compress(int[][] arr, int[] counts) {
        if (arr.length == 1 || canCompress(arr)) {
            counts[arr[0][0]]++;
            return;
        }

        int len = arr.length / 2;
        int[][] temp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        compress(temp.clone(), counts);

        for (int i = 0; i < len; i++) {
            for (int j = len; j < arr.length; j++) {
                temp[i][j - len] = arr[i][j];
            }
        }
        compress(temp.clone(), counts);

        for (int i = len; i < arr.length; i++) {
            for (int j = 0; j < len; j++) {
                temp[i - len][j] = arr[i][j];
            }
        }
        compress(temp.clone(), counts);

        for (int i = len; i < arr.length; i++) {
            for (int j = len; j < arr.length; j++) {
                temp[i - len][j - len] = arr[i][j];
            }
        }
        compress(temp.clone(), counts);
    }

    public boolean canCompress(int[][] arr) {
        int count0 = 0;
        int count1 = 0;
        for (int[] ints : arr) {
            count0 += Arrays.stream(ints).filter(n -> n == 0).count();
            count1 += Arrays.stream(ints).filter(n -> n == 1).count();
            if (count0 != 0 && count1 != 0) {
                return false;
            }
        }
        return true;
    }
}