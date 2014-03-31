public class Solution {
    public void sortColors(int[] A) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for (int i : A) {
            if (i == 0) {
                zeros++;
            } else if (i == 1) {
                ones++;
            } else {
                twos++;
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < zeros; i++) {
            list.add(0);
        }
        for (int i = 0; i < ones; i++) {
            list.add(1);
        }
        for (int i = 0; i < twos; i++) {
            list.add(2);
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = list.get(i);
        }
    }
}