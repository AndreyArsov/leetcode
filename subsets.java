public class Solution {
    private ArrayList<ArrayList<Integer>> answer;
    private ArrayList<Integer> S;
    private ArrayList<Integer> current;

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        answer = new ArrayList<ArrayList<Integer>>();
        if (S == null) {
            return answer;
        }

        this.S = new ArrayList<Integer>();
        for (int i = 0; i < S.length; i++) this.S.add(S[i]);

        Collections.sort(this.S);

        current = new ArrayList<Integer>();
        search(0);
        return answer;
    }

    private void search(int p) {
        if (p == S.size()) {
            ArrayList<Integer> newSubset = new ArrayList<Integer>();
            for (Integer i : current) {
                newSubset.add(i);
            }
            answer.add(newSubset);
            return;
        }

        search(p + 1);
        current.add(S.get(p));
        search(p + 1);
        current.remove(current.size() - 1);
    }
}