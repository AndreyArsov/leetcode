public class Solution {
    public double pow(double x, int n) {
        int sign = 1;
        int xsign = 1;
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            sign = -1;
            n = -n;
        }

        if (x < 0) {
            xsign = -1;
            x = -x;
        }

        double temp = 1;
        double prev = 1;
        for (int i = 0; i < n; i++) {
            temp *= x;
            if (temp == prev) {
                break;
            }
            prev = temp;
        }

        double answer = sign == 1 ? temp : 1/temp;
        if (xsign == -1 && n % 2 == 1) {
            answer = -answer;
        }

        return answer;
    }
}