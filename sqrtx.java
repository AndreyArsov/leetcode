public class Solution {
    public int sqrt(int x) {
        double low = 0;
        double high = x;
        while (Math.floor(low) != Math.floor(high)) {
            double mid = (low + high) / 2;
            if (mid * mid > x) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return (int)Math.floor(low);
    }
}