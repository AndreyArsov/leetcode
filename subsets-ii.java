public class Solution {
    ArrayList<ArrayList<Integer>> answer;
    ArrayList<Integer> keys;
    HashMap<Integer, Integer> count;
    ArrayList<Integer> subset;

    private void search(int p) {
        if (p == keys.size()) {
            ArrayList<Integer> newSubset = new ArrayList<Integer>();
            for (Integer i : subset) {
                newSubset.add(i);
            }
            answer.add(newSubset);
            return;
        }

        int key = keys.get(p);
        for (int i = 0; i <= count.get(key); i++) {
            for (int j = 0; j < i; j++) {
                subset.add(key);
            }

            search(p + 1);

            for (int j = 0; j < i; j++) {
                subset.remove(subset.size() - 1);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        answer = new ArrayList<ArrayList<Integer>>();
        if (num == null) {
            return answer;
        }

        keys = new ArrayList<Integer>();
        count = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            int c = 0;
            if (count.containsKey(num[i])) {
                c = count.get(num[i]);
            } else {
                keys.add(num[i]);
            }
            count.put(num[i], c + 1);
        }

        Collections.sort(keys);
        subset = new ArrayList<Integer>();

        search(0);
        return answer;
    }
}