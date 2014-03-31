public class Solution {
    private int[] A;
    private int[] maxLeft;
    private int[] maxRight;

    public int trap(int[] A) {
        this.A = A;
        if (A.length == 0) {
            return 0;
        }

        maxLeft = new int[A.length];
        maxRight = new int[A.length];
        maxLeft[0] = A[0];
        maxRight[A.length - 1] = A[A.length - 1];

        for (int i = 1; i < A.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], A[i]);
        }

        for (int i = A.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], A[i]);
        }

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            count += Math.min(maxLeft[i], maxRight[i]) - A[i];
        }

        return count;
    }
}