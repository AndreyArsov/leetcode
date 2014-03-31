public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }

        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }

        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            int value = matrix[x][y];
            if (value == target) {
                return true;
            } else if (value > target) {
                y--;
            } else {
                x++;
            }
        }

        return false;
    }
}