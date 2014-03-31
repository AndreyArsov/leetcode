public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(A[0]);

        int runningLength = 1;
        for (int p = 1; p < A.length; p++) {
            if (A[p] == A[p - 1]) {
                runningLength++;
            } else {
                runningLength = 1;
            }
            if (runningLength <= 2) {
                list.add(A[p]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            A[i] = list.get(i);
        }

        return list.size();
    }
}