public class Solution {
    public boolean canJump(int[] A) {
        if (A.length == 0) {
            return false;
        } else if (A.length == 1) {
            return true;
        }

        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (i <= max) {
                max = Math.max(max, A[i] + i);
            }
            if (max >= A.length - 1) {
                return true;
            }
        }

        return false;
    }
}