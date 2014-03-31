public class Solution {
    private ArrayList<String[]> answer;

    private void search(int n, int r, int[] A) {
        if (r == n) {
            String[] map = new String[n];
            for (int i = 0; i < n; i++) {
                String row = "";
                for (int j = 0; j < A[i]; j++) {
                    row += ".";
                }
                row += "Q";
                for (int j = A[i] + 1; j < n; j++) {
                    row += ".";
                }
                map[i] = row;
            }
            answer.add(map);
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

    public ArrayList<String[]> solveNQueens(int n) {
        answer = new ArrayList<String[]>();

        if (n == 0) {
            return answer;
        }

        search(n, 0, new int[n]);
        return answer;
    }
}