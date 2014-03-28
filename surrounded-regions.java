public class Solution {
    private char[][] board;
    private int height;
    private int width;
    private int[][] isExposed; /* 0 unkown; 1 exposed; 2 enclosed */

    private void flood(int x, int y, boolean seed) {
        if (x < 0 || x >= this.height || y < 0 || y >= this.width || this.board[x][y] == 'X') {
            return;
        }

        if (seed || isExposed[x][y] == 0) {
            isExposed[x][y] = 1;
            flood(x - 1, y, false);
            flood(x + 1, y, false);
            flood(x, y - 1, false);
            flood(x, y + 1, false);
        }
    }

    public void solve(char[][] board) {
        this.height = board.length;
        if (this.height == 0) {
            return;
        }
        this.width = board[0].length;
        this.board = board;

        isExposed = new int[height][width];

        for (int i = 0; i < this.height; i++) {
            isExposed[i][0] = board[i][0] == 'O' ? 1 : 2;
            isExposed[i][this.width - 1] = board[i][this.width - 1] == 'O' ? 1 : 2;
        }

        for (int j = 0; j < this.width; j++) {
            isExposed[0][j] = board[0][j] == 'O' ? 1 : 2;
            isExposed[this.height - 1][j] = board[this.height - 1][j] == 'O' ? 1 : 2;
        }

        for (int i = 0; i < this.height; i++) {
            flood(i, 0, true);
            flood(i, this.width - 1, true);
        }

        for (int j = 0; j < this.width; j++) {
            flood(0, j, true);
            flood(this.height - 1, j, true);
        }

        for (i = 0; i < this.height; i++) {
            for (j = 0; j < this.width; j++) {
                if (board[i][j] == 'O' && isExposed[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}