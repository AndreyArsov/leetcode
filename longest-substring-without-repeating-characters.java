public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int max = 1;
        boolean[][] map = new boolean[s.length()][255];

        for (int i = 0; i < s.length(); i++) {
            map[i][s.charAt(i)] = true;
            int j = i + 1;
            while (j < s.length()) {
                if (map[i][s.charAt(j)]) {
                    break;
                }
                map[i][s.charAt(j)] = true;
                j++;
            }

            int length = j - i;
            if (length > max) {
                max = length;
            }
        }

        return max;
    }
}