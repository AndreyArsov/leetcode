public class Solution {
    private String f(String s) {
        ArrayList<Character> c = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            c.add(s.charAt(i));
        }

        Collections.sort(c);
        String x = "";
        for (Character xc : c) {
            x = x + xc.toString();
        }
        return x;
    }

    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> answer = new ArrayList<String>();

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String s : strs) {
            String sig = f(s);
            ArrayList<String> friends = null;
            if (map.containsKey(sig)) {
                friends = map.get(sig);
            } else {
                friends = new ArrayList<String>();
            }
            friends.add(s);
            map.put(sig, friends);
        }

        for (String sig : map.keySet()) {
            ArrayList<String> friends = map.get(sig);
            if (friends.size() > 1) {
                ArrayList<String> list = new ArrayList<String>(friends);
                for (String friend : list) {
                    answer.add(friend);
                }
            }
        }

        return answer;
    }
}