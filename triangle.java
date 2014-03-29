public class Solution {
    private ArrayList<ArrayList<Integer>> triangle;

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }

        this.triangle = triangle;
        int levels = triangle.size();
        int[][] f = new int[levels][levels];

        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < levels; i++) {
            for (int j = 0; j <= i; j++) {
                int min = 0;
                if (i > 0 || j > 0) {
                    min = Integer.MAX_VALUE;
                    if (j != i) {
                        min = f[i-1][j];
                    }
                    if (j > 0) {
                        min = Math.min(min, f[i-1][j-1]);
                    }
                }

                f[i][j] = min + this.triangle.get(i).get(j);

                if (i == levels - 1 && f[i][j] < shortest) {
                    shortest = f[i][j];
                }
            }
        }

        return shortest;
    }
}