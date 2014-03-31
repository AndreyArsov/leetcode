public class Solution {
    private String[] mapping;
    private ArrayList<String> answer;

    private void search(String digits, int p, String word) {
        if (p == digits.length()) {
            answer.add(word);
            return;
        }

        String candidates = mapping[digits.charAt(p) - '0'];
        for (char c : candidates.toCharArray()) {
            search(digits, p + 1, word + Character.toString(c));
        }
    }

    public ArrayList<String> letterCombinations(String digits) {
        answer = new ArrayList<String>();
        mapping = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jlk",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };

        search(digits, 0, "");
        return answer;
    }
}