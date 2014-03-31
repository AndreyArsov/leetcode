public class Solution {
    private ArrayList<ArrayList<Integer>> answer;
    private int[] num;
    private int target;

    private void search(int p, int sum, ArrayList<Integer> current) {
        if (sum == target) {
            ArrayList<Integer> newAnswer = new ArrayList<Integer>();
            for (int i : current) {
                newAnswer.add(i);
            }
            answer.add(newAnswer);
            return;
        } else if (sum > target || p == num.length) {
            return;
        }

        for (int i = p; i < num.length; i++) {
            if (i == p || num[i] != num[i-1]) {
                current.add(num[i]);
                search(i + 1,  sum + num[i], current);
                current.remove(current.size() - 1);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        answer = new ArrayList<ArrayList<Integer>>();

        Arrays.sort(num);
        this.num = num;
        this.target = target;

        search(0, 0, new ArrayList<Integer>());

        return answer;
    }
}