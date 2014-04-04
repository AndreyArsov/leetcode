public class Solution {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];

        for (int j = num2.length() - 1; j >= 0; j--) {
            int offsetJ = num2.length() - 1 - j;
            int[] product = new int[num1.length() + num2.length()];
            int carry = 0;
            for (int i = num1.length() - 1; i >= 0; i--) {
                int offsetI = num1.length() - 1 - i;
                int p = (num2.charAt(j) - '0') * (num1.charAt(i) - '0') + carry;
                carry = p / 10;
                product[offsetI + offsetJ] = p % 10;
            }
            product[offsetJ + num1.length()] = carry;
    
            carry = 0;
            for (int i = 0; i < result.length; i++) {
                int sum = result[i] + product[i] + carry;
                carry = sum / 10;
                result[i] = sum % 10;
            }
        }
        
        String s = "";
        for (int i : result) {
            s = Integer.toString(i) + s;
        }
        
        while (s.length() > 1 && s.charAt(0) == '0') {
            s = s.substring(1);
        }

        return s;
    }
}