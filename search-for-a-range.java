public class Solution {
    public int[] searchRange(int[] A, int target) {
        int pos = search(A, 0, A.length - 1, target);
        if (pos == -1) {
            return new int[]{-1, -1};
        }

        int left = pos;
        int right = pos;
        while (left >= 0 && A[left] == target) {
            left--;
        }
        while (right < A.length && A[right] == target) {
            right++;
        }

        return new int[]{left + 1, right - 1};
    }

    private int search(int[] A, int left, int right, int target) {
        if (left > right) {
            return -1;
        } else if (left == right) {
            return A[left] == target ? left : -1;
        }

        int mid = (left + right) / 2;
        if (A[mid] == target) {
            return mid;
        } else if (A[mid] > target) {
            return search(A, left, mid - 1, target);
        } else {
            return search(A, mid + 1, right, target);
        }
    }
}