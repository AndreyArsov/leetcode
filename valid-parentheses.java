public class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> stack = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Character top = 'x';
            if (stack.size() > 0) {
                top = stack.get(stack.size() - 1);
            }

            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
                continue;
            }

            if (c == ')' && top != '(') {
                return false;
            }

            if (c == '}' && top != '{') {
                return false;
            }

            if (c == ']' && top != '[') {
                return false;
            }

            if (c == ')' && top == '(') {
                stack.remove(stack.size() - 1);
            } else if (c == ']' && top == '[') {
                stack.remove(stack.size() - 1);
            } else if (c == '}' && top == '{') {
                stack.remove(stack.size() - 1);
            }
        }

        return stack.size() == 0;
    }
}