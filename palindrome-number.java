public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        int length = (int)Math.log10(x) + 1;

        while (x >= 10) {
            int base = (int)Math.log10(x);
            int c = 1;
            for (int i = 0; i < base; i++) {
                c = c * 10;
            }
            int first = x / c;
            int last = x % 10;
            if (first != last) {
                return false;
            }

            x -= first * c;
            x -= last;
            x /= 10;
            length -= 2;

            if (length == 0) {
                return true;
            }

            int actualLength = (int)Math.log10(x) + 1;
            int discrepancy = length - actualLength;
            for (int i = 0; i < discrepancy; i++) {
                if (x % 10 != 0) {
                    return false;
                }
                x /= 10;
                length -= 2;
                if (length == 0) {
                    return true;
                }
            }
        }

        return true;
    }
}