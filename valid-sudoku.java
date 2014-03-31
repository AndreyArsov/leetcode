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
    public boolean isValidSudoku(char[][] board) {
        boolean answer = true;
        for (int i = 0; i < 9; i++) {
            answer = answer && isValid(makeRow(board, i));
            answer = answer && isValid(makeColumn(board, i));
        }

        for (int x = 0; x < 9; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                answer = answer && isValid(makeBlock(board, x, y));
            }
        }

        return answer;
    }
}