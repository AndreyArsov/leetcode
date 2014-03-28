public class Solution {
    public int singleNumber(int[] A) {
        int x = 0;
        for (int i : A) {
            x ^= i;
        }
        return x;
    }
}