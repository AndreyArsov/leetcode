public class Solution {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }

        if (p.length() >= 2 && p.charAt(1) == '*') {
            char pc = p.charAt(0);
            int i = 0;
            boolean match = false;
            while (i < s.length() && (pc == '.' || pc == s.charAt(i))) {
                match = match || isMatch(s.substring(i + 1), p.substring(2));
                i++;
            }
            return match || isMatch(s, p.substring(2));
        } else {
            if (s.length() == 0 || p.length() == 0) {
                return false;
            }
            char pc = p.charAt(0);
            char sc = s.charAt(0);
            if (pc != '.') {
                return (pc == sc) && isMatch(s.substring(1), p.substring(1));
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }
    }
}