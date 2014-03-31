public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int closest = 0;
        int minDiff = Integer.MAX_VALUE;

        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i - 1] == num[i]) {
                continue;
            }
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int diff = Math.abs(target - num[i] - num[j] - num[k]);
                if (diff < minDiff) {
                    minDiff = diff;
                    closest = num[i] + num[j] + num[k];
                }

                if (num[j] + num[k] == target - num[i]) {
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
                } else if (num[i] + num[j] + num[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return closest;
    }
}