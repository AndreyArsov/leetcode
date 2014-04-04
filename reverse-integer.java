public class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;

        int answer = 0;
        x = Math.abs(x);
        while (x > 0) {
            answer = answer * 10 + x % 10;
            x = x / 10;
        }

        if (isNegative) {
            return -answer;
        } else {
            return answer;
        }
    }
}