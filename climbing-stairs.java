public class Solution {
    public int f(int n) {
        if (m[n] > 0) {
            return m[n];
        }

        if (n == 0 || n == 1) {
            m[n] = 1;
            return 1;
        }

        int result = f(n - 1) + f(n - 2);
        m[n] = result;
        return result;
    }

    private int[] m;

    public int climbStairs(int n) {
        m = new int[n + 1];
        return f(n);
    }
}