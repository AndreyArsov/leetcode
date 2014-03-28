public class Solution {
    public int numDistinct(String S, String T) {
        if (T.length() == 0) {
            return 1;
        } else if (S.length() == 0) {
            return 0;
        }

        int[][] f = new int[S.length()][T.length()];
        f[0][0] = (S.charAt(0) == T.charAt(0)) ? 1 : 0;

        for (int i = 1; i < S.length(); i++) {
            for (int j = 0; j <= Math.min(T.length() - 1, i); j++) {
                f[i][j] = f[i - 1][j];
                if (S.charAt(i) == T.charAt(j)) {
                    if (j == 0) {
                        f[i][j]++;
                    } else {
                        f[i][j] += f[i - 1][j - 1];
                    }
                }
            }
        }

        return f[S.length() - 1][T.length() - 1];
    }
}