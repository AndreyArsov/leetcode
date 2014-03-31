public class Solution {
    private boolean[][] rotated;
    private int[][] matrix;
    private int n;

    private boolean rotateNextRing() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!rotated[i][j]) {
                    ArrayList<Integer> xs = new ArrayList<Integer>();
                    ArrayList<Integer> ys = new ArrayList<Integer>();
                    rotated[i][j] = true;
                    int nextX = j;
                    int nextY = n - 1 - i;
                    while (!rotated[nextX][nextY]) {
                        xs.add(nextX);
                        ys.add(nextY);
                        rotated[nextX][nextY] = true;
                        int t = nextX;
                        nextX = nextY;
                        nextY = n - 1 - t;
                    }

                    int prev = matrix[i][j];
                    for (int k = 0; k < xs.size(); k++) {
                        int x = xs.get(k);
                        int y = ys.get(k);
                        int t = matrix[x][y];
                        matrix[x][y] = prev;
                        prev = t;
                    }

                    matrix[i][j] = prev;
                    return true;
                }
            }
        }

        return false;
    }

    public void rotate(int[][] matrix) {
        n = matrix.length;
        if (n == 0) {
            return;
        }

        this.matrix = matrix;
        rotated = new boolean[n][n];

        while (rotateNextRing()) {}
    }
}