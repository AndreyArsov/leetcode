public class Solution {
    private ArrayList<ArrayList<Integer>> answer;
    private int k;
    private int n;

    private void search(int filled, ArrayList<Integer> result, int last) {
        if (filled == k) {
            ArrayList<Integer> clone = new ArrayList<Integer>();
            for (Integer i : result) {
                clone.add(i);
            }
            answer.add(clone);
            return;
        }

        int start = filled == 0 ? 1 : last + 1;
        for (int i = start; i <= n; i++) {
            result.add(i);
            search(filled + 1, result, i);
            result.remove(result.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        answer = new ArrayList<ArrayList<Integer>>();
        search(0, new ArrayList<Integer>(), 0);
        return answer;
    }
}
