public class Solution {
    private ArrayList<ArrayList<Integer>> answer;
    private int target;
    private int[] candidates;
    private int[] assignment;

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);

        this.target = target;
        this.candidates = candidates;
        assignment = new int[candidates.length];

        search(0, 0);
        return answer;
    }

    private void search(int p, int sum) {
        if (p == candidates.length) {
            if (sum == target) {
                ArrayList<Integer> newAnswer = new ArrayList<Integer>();
                for (int i = 0; i < candidates.length; i++) {
                    for (int j = 0; j < assignment[i]; j++) {
                        newAnswer.add(candidates[i]);
                    }
                }
                answer.add(newAnswer);
            }
            return;
        }

        int remain = target - sum;
        for (int i = 0; i <= remain / candidates[p]; i++) {
            assignment[p] = i;
            search(p + 1, sum + i * candidates[p]);
        }
        assignment[p] = 0;
    }
}