public class Solution {
    public String simplifyPath(String path) {
        path = path.trim();

        String[] folders = path.split("/");
        Stack s = new Stack();
        for (String folder : folders) {
            if (folder.length() == 0 || folder.equals(".")) {
                continue;
            } else if (folder.equals("..")) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(folder);
            }
        }

        Stack ss = new Stack();
        while (!s.isEmpty()) {
            ss.push(s.pop());
        }

        s = ss;

        String answer = "";
        while (!s.isEmpty()) {
            answer += "/" + s.pop().toString();
        }
        if (answer.length() == 0) {
            return "/";
        } else {
            return answer;
        }

    }
}