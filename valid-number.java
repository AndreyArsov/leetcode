public class Solution {
    public boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != 'e' && c != '+' && c != '-' && c != '.' && c != ' ' && !(c >= '0' && c <= '9')) {
                return false;
            }
        }

        boolean success = false;
        try {
            Float.parseFloat(s);
            success = true;
        } catch (Exception e) {}

        return success;
    }
}