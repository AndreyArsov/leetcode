public class Solution {
    public String reverseWords(String s) {
        ArrayList<String> words = new ArrayList<String>();
        String cached = "";
        s += " ";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (cached.length() > 0) {
                    words.add(0, cached);
                    cached = "";
                }
            } else {
                cached += Character.toString(c);
            }
        }

        String answer = "";
        if (words.size() > 0) {
            answer = words.get(0);
            for (int i = 1; i < words.size(); i++) {
                answer += " " + words.get(i);
            }
        }
        return answer;
    }
}