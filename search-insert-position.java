public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A.length == 0 || target < A[0]) {
            return 0;
        }

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == target) {
                return i;
            } else if (A[i] < target && target < A[i + 1]) {
                return i + 1;
            }
        }

        int last = A.length - 1;
        if (A[last] == target) {
            return last;
        } else {
            return last + 1;
        }
    }
}