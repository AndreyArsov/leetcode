public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length + B.length;
        int[] C = new int[m];
        int pA = 0;
        int pB = 0;
        while (pA < A.length || pB < B.length) {
            if (pA < A.length && pB < B.length) {
                if (pB == B.length || A[pA] < B[pB]) {
                    C[pA + pB] = A[pA];
                    pA++;
                } else {
                    C[pA + pB] = B[pB];
                    pB++;
                }
            } else if (pA == A.length) {
                C[pA + pB] = B[pB];
                pB++;
            } else {
                C[pA + pB] = A[pA];
                pA++;
            }
        }

        if (m % 2 == 1) {
            return (double)C[m / 2];
        } else {
            return ((double)(C[m / 2 - 1] + C[m / 2])) / 2;
        }
    }
}