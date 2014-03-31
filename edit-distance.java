public class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        if (l1 == 0 || l2 == 0) {
            return Math.max(l1, l2);
        }

        int[][] f = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = Math.max(i, j);
                } else {
                    int choice1 =  (word1.charAt(i - 1) == word2.charAt(j - 1)) ? f[i - 1][j - 1] : (f[i - 1][j - 1] + 1);
                    int choice2 = f[i - 1][j] + 1;
                    int choice3 = f[i][j - 1] + 1;
                    f[i][j] = Math.min(choice1, Math.min(choice2, choice3));
                }
            }
        }

        return f[l1][l2];
    }
}