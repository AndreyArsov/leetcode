public class Solution {
    private int indexOfLastElementInA;

    private void shiftOneLeft(int A[], int index) {
        for (int i = index - 1; i < indexOfLastElementInA; i++) {
            A[i] = A[i+1];
        }
        indexOfLastElementInA--;
    }

    public int removeElement(int[] A, int elem) {
        indexOfLastElementInA = A.length - 1;

        int p = 0;
        while (p <= indexOfLastElementInA) {
            if (A[p] == elem) {
                shiftOneLeft(A, p+1);
            } else {
                p++;
            }
        }

        return indexOfLastElementInA + 1;
    }
}