import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        first(triangle, 0, 0, 0);

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                nums.add(triangle[i][j]);
            }
        }
        return nums.stream().mapToInt(Integer::intValue).toArray();
    }

    public void first(int[][] triangle, int row, int col, int num) {
        int n = triangle.length;
        if (row >= n || col >= n || triangle[row][col] > 0) {
            return;
        }

        while (row < n && triangle[row][col] == 0) {
            num++;
            triangle[row][col] = num;
            row++;
        }

        second(triangle, row - 1, col + 1, num);
    }

    public void second(int[][] triangle, int row, int col, int num) {
        int n = triangle.length;
        if (row >= n || col >= n || triangle[row][col] > 0) {
            return;
        }
        while (col < n && triangle[row][col] == 0) {
            num++;
            triangle[row][col] = num;
            col++;
        }
        third(triangle, row - 1, col - 2, num);
    }

    public void third(int[][] triangle, int row, int col, int num) {
        if (row < 0 || col < 0 || triangle[row][col] > 0) {
            return;
        }
        while (row > 0 && col > 0 && triangle[row][col] == 0) {
            num++;
            triangle[row][col] = num;
            row--;
            col--;
        }

        first(triangle, row + 2, col + 1, num);
    }
}