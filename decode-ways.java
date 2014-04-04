public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] f = new int[s.length()];
        f[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            f[i] =  s.charAt(i) == '0' ? 0 : f[i - 1];
            int num = 10 * (s.charAt(i - 1) - '0') + s.charAt(i) - '0';
            if (num >= 10 && num <= 26) {
                f[i] += (i >= 2) ? f[i - 2] : 1;
            }
        }

        return f[s.length() - 1];
    }
}