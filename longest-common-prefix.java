public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        int p = 0;
        String prefix = "";
        while (true) {
            if (p >= strs[0].length()) {
                break;
            }

            boolean different = false;
            for (int i = 1; i < strs.length; i++) {
                if (p >= strs[i].length() || strs[i].charAt(p) != strs[0].charAt(p)) {
                    different = true;
                    break;
                }
            }
            if (different) {
                break;
            } else {
                prefix = prefix + Character.toString(strs[0].charAt(p));
                p++;
            }
        }

        return prefix;
    }
}