public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> parenStack = new Stack<Character>();
        Stack<Integer> indexStack = new Stack<Integer>();

        boolean[] isValid = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && !parenStack.empty() && parenStack.peek() == '(') {
                parenStack.pop();
                int matchingIndex = indexStack.pop();
                isValid[matchingIndex] = true;
                isValid[i] = true;
            } else {
                parenStack.push(c);
                indexStack.push(i);
            }
        }

        int maxLength = 0;
        int runningLength = 0;
        for (int i = 0; i < isValid.length; i++) {
            if (isValid[i]) {
                runningLength++;
                if (runningLength > maxLength) {
                    maxLength = runningLength;
                }
            } else {
                runningLength = 0;
            }
        }

        return maxLength;
    }
}