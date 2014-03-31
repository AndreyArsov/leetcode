public class Solution {
    public int lengthOfLastWord(String s) {
        String[] strings = s.split("\\s+");
        if (strings == null || strings.length == 0) {
            return 0;
        }
        return strings[strings.length - 1].length();
    }
}