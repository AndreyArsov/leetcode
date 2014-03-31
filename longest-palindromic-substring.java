public class Solution {
    public String longestPalindrome(String s) {
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            String expanded = expand(s, i - 1, i + 1);
            if (expanded.length() > longest.length()) {
                longest = expanded;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                String expanded = expand(s, i - 1, i + 2);
                if (expanded.length() > longest.length()) {
                    longest = expanded;
                }
            }
        }

        return longest;
    }

    private String expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}