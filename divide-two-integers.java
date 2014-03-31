public class Solution {
    public int divide(int dividend, int divisor) {
        long count = 0;
        long dd = dividend;
        long dr = divisor;

        int sign = 1;
        if (dd > 0 && dr < 0) {
            sign = -1;
        } else if (dd < 0 && dr > 0) {
            sign = -1;
        }

        dd = Math.abs(dd);
        dr = Math.abs(dr);

        long substract = dr;
        long power = 1;

        while (dd >= dr) {
            while (dd >= substract) {
                dd -= substract;
                count += power;
                substract += substract;
                power += power;
            }

            substract = dr;
            power = 1;
        }

        if (sign > 0) {
            return (int)count;
        } else {
            return (int)(-count);
        }
    }
}