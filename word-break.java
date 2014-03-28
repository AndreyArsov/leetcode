public class Solution {
    private String s;
    private Set<String> dictionary;
    private int[][] memoization;

    private boolean search(int i, int j) {
        if (memoization[i][j] > 0) {
            return memoization[i][j] == 1;
        }

        String substring = s.substring(i, j + 1);

        if (dictionary.contains(substring)) {
            memoization[i][j] = 1;
            return true;
        }

        for (int k = i; k < j; k++) {
            if (search(i, k) && search(k + 1, j)) {
                memoization[i][j] = 1;
                return true;
            }
        }

        memoization[i][j] = 2;
        return false;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        this.s = s;
        this.dictionary = dict;
        memoization = new int[s.length()][s.length()];
        return search(0, s.length() - 1);
    }
}