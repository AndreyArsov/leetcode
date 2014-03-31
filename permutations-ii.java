public class Solution {
    private HashSet<Integer> keys;
    private HashMap<Integer, Integer> count;
    private ArrayList<ArrayList<Integer>> answer;

    private void search(int n, ArrayList<Integer> current) {
        if (current.size() == n) {
            ArrayList<Integer> newAnswer = new ArrayList<Integer>();
            for (int i : current) {
                newAnswer.add(i);
            }
            answer.add(newAnswer);
            return;
        }

        for (int key : keys) {
            int c = count.get(key);
            if (c > 0) {
                current.add(key);
                count.put(key, c - 1);
                search(n, current);
                count.put(key, c);
                current.remove(current.size() - 1);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        answer = new ArrayList<ArrayList<Integer>>();
        keys = new HashSet<Integer>();
        count = new HashMap<Integer, Integer>();
        for (int i : num) {
            keys.add(i);
            int c = 0;
            if (count.containsKey(i)) {
                c = count.get(i);
            }
            count.put(i, c + 1);
        }

        search(num.length, new ArrayList<Integer>());

        return answer;
    }
}