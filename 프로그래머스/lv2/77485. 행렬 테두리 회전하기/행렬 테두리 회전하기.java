import java.util.*;

class Solution {
    private int[][] board;
    private List<Integer> moved;
    private int[] answer;

    public int[] solution(int rows, int columns, int[][] queries) {

        board = new int[rows + 1][columns + 1];
        int num = 0;
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                num++;
                board[i][j] = num;
            }
//            System.out.println(Arrays.toString(board[i]));
        }

        moved = new ArrayList<>();
        answer = new int[queries.length];
        changePoint(queries);

//        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public void changePoint(int[][] queries) {
        int temp1, temp2;
        int x1, y1, x2, y2;
        for (int i = 0; i < queries.length; i++) {
            x1 = queries[i][0];
            y1 = queries[i][1];
            x2 = queries[i][2];
            y2 = queries[i][3];

            // right
            temp2 = board[x1][y1];
            for (int j = y1; j < y2; j++) {
                moved.add(temp2);
                temp1 = temp2;
                temp2 = board[x1][j + 1];
                board[x1][j + 1] = temp1;
            }

            // down
            for (int j = x1; j < x2; j++) {
                moved.add(temp2);
                temp1 = temp2;
                temp2 = board[j + 1][y2];
                board[j + 1][y2] = temp1;
            }

            // left
            for (int j = y2; j > y1; j--) {
                moved.add(temp2);
                temp1 = temp2;
                temp2 = board[x2][j - 1];
                board[x2][j - 1] = temp1;
            }

            // up
            for (int j = x2; j > x1; j--) {
                moved.add(temp2);
                temp1 = temp2;
                temp2 = board[j - 1][y1];
                board[j - 1][y1] = temp1;
            }

//            System.out.println(moved);
            moved.sort(Comparator.naturalOrder());
            answer[i] = moved.get(0);
            moved = new ArrayList<>();
        }
    }
}