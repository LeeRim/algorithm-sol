class Solution {
    public int solution(String[] board) {
        int oCount = 0;
        int xCount = 0;
        for (String s : board) {
            for (int i = 0; i < 3; i++) {
                if (s.charAt(i) == 'O') {
                    oCount++;
                    continue;
                }
                if (s.charAt(i) == 'X') {
                    xCount++;
                }
            }
        }

        if (oCount == xCount || xCount + 1 == oCount) {
            int oDoneCount = doneCount(board, 'O');
            int xDoneCount = doneCount(board, 'X');

            if (xDoneCount == 0) {
                if (oDoneCount > 0 && oCount == xCount) {
                    return 0;
                }
                return 1;
            }
            if (oDoneCount == 0 && oCount == xCount) {
                return 1;
            }
        }

        return 0;
    }

    public int doneCount(String[] board, char player) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player) {
                if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(0) == board[i].charAt(2)) {
                    count++;
                }
            }
            if (board[0].charAt(i) == player) {
                if (board[0].charAt(i) == board[1].charAt(i) && board[0].charAt(i) == board[2].charAt(i)) {
                    count++;
                }
            }
        }

        if (board[1].charAt(1) == player) {
            if (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) {
                count++;
            }
            if (board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)) {
                count++;
            }
        }

        return count;
    }
}