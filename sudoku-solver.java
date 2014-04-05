public class Solution {
    private boolean isValid(char[] p) {
        boolean[] appear = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (p[i] != '.') {
                int v = p[i] - '0';
                if (v == 0 || appear[v]) {
                    return false;
                }
                appear[v] = true;
            }
        }
        return true;
    }

    private char[] makeRow(char[][] board, int i) {
        char[] row = new char[9];
        for (int j = 0; j < 9; j++) {
            row[j] = board[i][j];
        }
        return row;
    }

    private char[] makeColumn(char[][] board, int j) {
        char[] column = new char[9];
        for (int i = 0; i < 9; i++) {
            column[i] = board[i][j];
        }
        return column;
    }

    private char[] makeBlock(char[][] board, int i, int j) {
        char[] block = new char[9];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                block[x * 3 + y] = board[i + x][j + y];
            }
        }
        return block;
    }

    private boolean isValidSudoku(char[][] board) {
        boolean answer = true;
        for (int i = 0; i < 9; i++) {
            answer = answer && isValid(makeRow(board, i));
            answer = answer && isValid(makeColumn(board, i));
        }

        if (answer) {
            for (int x = 0; x < 9; x += 3) {
                for (int y = 0; y < 9; y += 3) {
                    answer = answer && isValid(makeBlock(board, x, y));
                }
            }
        }

        return answer;
    }

    private boolean search(char[][] board, int p) {
        if (p == 9 * 9) {
            return isValidSudoku(board);
        }

        if (!isValidSudoku(board)) {
            return false;
        }

        int x = p / 9;
        int y = p % 9;
        if (board[x][y] == '.') {
            for (char c = '1'; c <= '9'; c++) {
                board[x][y] = c;
                if (search(board, p + 1)) {
                    return true;
                }
            }
            board[x][y] = '.';
        } else {
            if (search(board, p + 1)) {
                return true;
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        search(board, 0);
    }
}