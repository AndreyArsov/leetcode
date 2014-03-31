public class Solution {
    int m;
    int n;

    private enum Direction {
        Right, Below, Left, Above
    }

    private Direction getNextDirection(Direction d) {
        if (d == Direction.Right) {
            return Direction.Below;
        } else if (d == Direction.Below) {
            return Direction.Left;
        } else if (d == Direction.Left) {
            return Direction.Above;
        } else {
            return Direction.Right;
        }
    }

    private int[] getNextPosition(boolean[][] visited, int x, int y, Direction d) {
        int nextX = x;
        int nextY = y;

        if (d == Direction.Right) {
            nextY++;
        } else if (d == Direction.Below) {
            nextX++;
        } else if (d == Direction.Left) {
            nextY--;
        } else {
            nextX--;
        }

        if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
            return new int[] { nextX, nextY };
        } else {
            return null;
        }
    }

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        m = matrix.length;
        if (m == 0) {
            return answer;
        }
        n = matrix[0].length;
        if (n == 0) {
            return answer;
        }

        int currentX = 0;
        int currentY = 0;
        Direction d = Direction.Right;
        boolean[][] visited = new boolean[m][n];
        int remaining = m * n;

        while (remaining > 0) {
            answer.add(matrix[currentX][currentY]);
            visited[currentX][currentY] = true;
            remaining--;

            if (remaining > 0) {
                int[] next = null;
                while (next == null) {
                    next = getNextPosition(visited, currentX, currentY, d);
                    if (next == null) {
                        d = getNextDirection(d);
                    }
                }

                currentX = next[0];
                currentY = next[1];
            }
        }

        return answer;
    }
}