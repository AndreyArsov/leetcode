public class Solution {
    private int indexOfLastElementInA;

    private void shiftOneRight(int A[], int index) {
        for (int i = indexOfLastElementInA + 1; i > index; i--) {
            A[i] = A[i - 1];
        }
        indexOfLastElementInA++;
    }

    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null || n == 0) {
            return;
        }

        indexOfLastElementInA = m - 1;

        int pA = 0;
        int pB = 0;
        while (pB < n) {
            if (pA > indexOfLastElementInA || B[pB] < A[pA]) {
                shiftOneRight(A, pA);
                A[pA] = B[pB];
                pB++;
            } else {
                if (pA <= indexOfLastElementInA) {
                    pA++;
                }
            }
        }
    }
}

