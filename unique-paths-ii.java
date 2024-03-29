public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    map[i][j] = 0;
                } else {
                    if (i == 0 && j > 0) {
                        map[i][j] = map[i][j - 1];
                    } else if (i > 0 && j == 0) {
                        map[i][j] = map[i - 1][j];
                    } else if (i == 0 && j == 0) {
                        map[i][j] = obstacleGrid[i][j] == 1 ? 0 : 1;
                    } else {
                        map[i][j] = map[i - 1][j] + map[i][j - 1];
                    }
                }
            }
        }

        return map[m - 1][n - 1];
    }
}