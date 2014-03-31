public class Solution {
    private int m;
    private int n;
    private boolean[][] visited;
    private char[][] board;
    private String word;

    private int[] validatePosition(int x, int y, int dx, int dy, int p) {
        int newX = x + dx;
        int newY = y + dy;
        if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && board[newX][newY] == word.charAt(p + 1)) {
            return new int[] { newX, newY };
        } else {
            return null;
        }
    }

    private boolean search(int x, int y, int p) {
        if (p == word.length() - 1) {
            return true;
        }

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if ((dx == 0 || dy == 0) && dx + dy != 0) {
                    int[] newPosition = validatePosition(x, y, dx, dy, p);
                    if (newPosition != null) {
                        int newX = newPosition[0];
                        int newY = newPosition[1];
                        visited[newX][newY] = true;
                        boolean result = search(newX, newY, p + 1);
                        visited[newX][newY] = false;
                        if (result) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return word.length() == 0;
        }
        n = board[0].length;
        if (n == 0) {
            return word.length() == 0;
        }

        if (word.length() == 0) {
            return true;
        }

        this.board = board;
        this.word = word;

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (board[x][y] == word.charAt(0)) {
                    visited = new boolean[m][n];
                    visited[x][y] = true;
                    boolean result = search(x, y, 0);
                    if (result) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}