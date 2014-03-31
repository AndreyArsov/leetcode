public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return new int[]{1};
        }

        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry +  ((i == digits.length - 1) ? 1 : 0);
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        if (carry > 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int j = 1; j < newDigits.length; j++) {
                newDigits[j] = digits[j-1];
            }
            return newDigits;
        } else {
            return digits;
        }
    }
}