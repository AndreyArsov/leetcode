public class Solution {
    public int maxSubArray(int[] A) {
        int best = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            best = best + A[i];
            if (best > max) {
                max = best;
            }
            best = Math.max(0, best);
        }

        return max;
    }
}