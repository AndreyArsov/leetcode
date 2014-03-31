public class Solution {
    private ArrayList<String> result;

    private void search(int remainOpen, int remainClose, Stack<Character> stack, StringBuilder current) {
        if (remainOpen == 0 && remainClose == 0) {
            result.add(current.toString());
            return;
        }

        if (remainOpen > 0) {
            current.append('(');
            stack.push('(');
            search(remainOpen - 1, remainClose, stack, current);
            stack.pop();
            current.deleteCharAt(current.length() - 1);
        }

        if (remainClose > 0 && !stack.empty() && stack.peek() == '(') {
            current.append(')');
            stack.pop();
            search(remainOpen, remainClose - 1, stack, current);
            stack.push('(');
            current.deleteCharAt(current.length() - 1);
        }
    }

    public ArrayList<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        search(n, n, new Stack<Character>(), new StringBuilder());
        return result;
    }
}