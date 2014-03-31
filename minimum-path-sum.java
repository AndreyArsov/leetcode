public  class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int m = grid.length;
        if (m == 0) {
            return 0;
        }

        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }

        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = grid[i][j];
                    continue;
                }
                int above = i > 0 ? f[i - 1][j] : Integer.MAX_VALUE;
                int left = j > 0 ? f[i][j - 1] : Integer.MAX_VALUE;
                f[i][j] = Math.min(above, left) + grid[i][j];
            }
        }

        return f[m - 1][n - 1];
    }
}