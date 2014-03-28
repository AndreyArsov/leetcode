public class Solution {
    private ArrayList<ArrayList<String>> answer;
    private HashSet<String> palindroms;
    private HashSet<String> notPalindroms;

    private boolean isPalindrom(String s) {
        if (palindroms.contains(s)) {
            return true;
        }

        if (notPalindroms.contains(s)) {
            return false;
        }

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                notPalindroms.add(s);
                return false;
            }
        }

        palindroms.add(s);
        return true;
    }

    private void search(String remaining, ArrayList<String> result) {
        if (remaining.length() == 0) {
            ArrayList<String> newResult = new ArrayList<String>();
            for (String s : result) {
                newResult.add(s);
            }
            answer.add(newResult);
            return;
        }

        for (int i = 1; i <= remaining.length(); i++) {
            String s = remaining.substring(0, i);
            if (isPalindrom(s)) {
                result.add(s);
                search(remaining.substring(i), result);
                result.remove(result.size() - 1);
            }
        }
    }

    public ArrayList<ArrayList<String>> partition(String s) {
        palindroms = new HashSet<String>();
        notPalindroms = new HashSet<String>();
        answer = new ArrayList<ArrayList<String>>();
        search(s, new ArrayList<String>());
        return answer;
    }
}