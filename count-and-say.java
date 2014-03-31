public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        while (n > 1) {
            s = make(s);
            n--;
        }
        return s;
    }

    private String make(String s) {
        String result = "";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                count++;
            } else {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    count++;
                } else {
                    result += Integer.toString(count) + Character.toString(s.charAt(i - 1));
                    count = 1;
                }
            }
        }

        if (count > 0) {
            result += Integer.toString(count) + Character.toString(s.charAt(s.length() - 1));
        }

        return result;
    }
}