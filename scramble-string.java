public class Solution {
    private boolean isPermutation(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return (new String(c1)).equals(new String(c2));
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        if (!isPermutation(s1, s2)) {
            return false;
        }

        for (int i = 1; i <= s1.length() - 1; i++) {
            String s1Left = s1.substring(0, i);
            String s1Right = s1.substring(i);

            String s2Left = s2.substring(0, i);
            String s2Right = s2.substring(i);

            String s2Left2 = s2.substring(0, s2.length() - i);
            String s2Right2 = s2.substring(s2.length() - i);

            if ((isScramble(s1Left, s2Left) && isScramble(s1Right, s2Right)) ||
                (isScramble(s1Left, s2Right2) && isScramble(s1Right, s2Left2)))
            {
                return true;
            }
        }

        return false;
    }
}