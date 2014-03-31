public class Solution {
    public int search(int[] A, int target) {
        return S(A, target, 0, A.length - 1);
    }

    private int S(int[] A, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (A[mid] == target) {
            return mid;
        }

        if (mid == left) {
            return S(A, target, mid + 1, right);
        } else if (mid == right) {
            return S(A, target, left, mid - 1);
        } else if (left == right || A[left] == A[right]) {
            return (A[left] == target) ? left : -1;
        } else if (A[left] < A[right]) {
            if (A[mid] < target) {
                return S(A, target, mid + 1, right);
            } else {
                return S(A, target, left, mid - 1);
            }
        } else {
            if (A[mid] > A[left]) {
                if (A[left] <= target && target <= A[mid]) {
                    return S(A, target, left, mid - 1);
                } else {
                    return S(A, target, mid + 1, right);
                }
            } else {
                if (A[mid] <= target && target <= A[right]) {
                    return S(A, target, mid + 1, right);
                } else {
                    return S(A, target, left, mid - 1);
                }
            }
        }
    }
}