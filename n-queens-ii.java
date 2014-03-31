public class Solution {
    private int answer;

    // A[i] = j <=> Q @ ith Row jth Col
    // Currently populating rth row
    private void search(int n, int r, int[] A) {
        if (r == n) {
            answer++;
            return;
        }

        for (int c = 0; c < n; c++) {
            A[r] = c;
            if (isValid(A, r)) {
                search(n, r + 1, A);
            }
        }
    }

    private boolean isValid(int[] A, int r) {
        for (int i = 0; i < r; i++) {
            if (A[i] == A[r] || Math.abs(A[i] - A[r]) == r - i) {
                return false;
            }
        }
        return true;
    }

    public int totalNQueens(int n) {
        answer = 0;

        if (n == 0) {
            return answer;
        }

        search(n, 0, new int[n]);
        return answer;
    }
}