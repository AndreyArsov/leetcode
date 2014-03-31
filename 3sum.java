public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();

        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i - 1] == num[i]) {
                continue;
            }

            int target = -num[i];
            int j = i+1;
            int k = num.length - 1;
            while (j < k) {
                int sum = num[j] + num[k];
                if (sum == target) {
                    ArrayList<Integer> newAnswer = new ArrayList<Integer>();
                    newAnswer.add(-target);
                    newAnswer.add(num[j]);
                    newAnswer.add(num[k]);
                    answer.add(newAnswer);
                    int numJ = num[j];
                    int numK = num[k];
                    k--;
                    j++;
                    while (k >= 0 && num[k] == numK) {
                        k--;
                    }
                    while (j < num.length && num[j] == numJ) {
                        j++;
                    }
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return answer;
    }
}