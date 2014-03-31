public class Solution {
    private char[] s1;
    private char[] s2;
    private char[] s3;
    private int[][] answer; // 0 unknown; 1 true; 2 false

    private boolean search(int i1, int i2, int i3) {
        if (answer[i1][i2] > 0) {
            return answer[i1][i2] == 1;
        }

        if (i3 == s3.length) {
            answer[i1][i2] = 1;
            return true;
        }

        boolean result = false;

        if (i1 < s1.length && s1[i1] == s3[i3]) {
            result = search(i1 + 1, i2, i3 + 1);
        }

        if (!result && i2 < s2.length && s2[i2] == s3[i3]) {
            result = search(i1, i2 + 1, i3 + 1);
        }

        answer[i1][i2] = result ? 1 : 2;
        return result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1.toCharArray();
        this.s2 = s2.toCharArray();
        this.s3 = s3.toCharArray();

        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        answer = new int[s1.length() + 1][s2.length() + 1];
        return search(0, 0, 0);
    }
}