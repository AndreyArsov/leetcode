public class Solution {
    private ArrayList<String> solutions;

    public ArrayList<String> restoreIpAddresses(String s) {
        solutions = new ArrayList<String>();
        solve(s, new ArrayList<String>());
        return solutions;
    }

    private void solve(String s, ArrayList<String> parts) {
        if (s.length() == 0) {
            if (parts.size() < 4) {
                return;
            }

            String ip = "";
            for (String part : parts) {
                if (part.charAt(0) == '0' && part.length() > 1) {
                    return;
                }

                ip += part + ".";
            }

            if (parts.size() > 0) {
                ip = ip.substring(0, ip.length() - 1);
            }

            solutions.add(ip);
            return;
        }

        char nextDigit = s.charAt(s.length() - 1);
        ArrayList<String> newParts = new ArrayList<String>(parts);

        if (parts.size() > 0) {
            String firstPart = parts.get(0);
            String newFirstPart = Character.toString(nextDigit) + firstPart;
            if (Integer.parseInt(newFirstPart) <= 255) {
                newParts.set(0, newFirstPart);
                solve(s.substring(0, s.length() - 1), newParts);
            }
        }

        if (parts.size() < 4) {
            newParts = new ArrayList<String>(parts);
            newParts.add(0, Character.toString(nextDigit));
            solve(s.substring(0, s.length() - 1), newParts);
        }
    }
}