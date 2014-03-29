public class Solution {
    private String safeChar(String input)
    {
        HashSet<Character> allowedSet = new HashSet<Character>();
        for (char c : "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()) {
            allowedSet.add(c);
        }

        StringBuilder result = new StringBuilder();
        for (char c : input.toString().toCharArray())
        {
            if (allowedSet.contains(c)) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public boolean isPalindrome(String s) {
        String ss = safeChar(s).toLowerCase();
        return ss.equals(new StringBuilder(ss).reverse().toString());
    }
}