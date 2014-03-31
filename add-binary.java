public class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString();

        while (a.length() > b.length()) {
            b += "0";
        }

        while (b.length() > a.length()) {
            a += "0";
        }

        int carry = 0;
        String answer = "";

        for (int i = 0; i < a.length(); i++) {
            int sum = a.charAt(i) - '0' + b.charAt(i) - '0' + carry;
            if (sum == 0) {
                answer += "0";
                carry = 0;
            } else if (sum == 1) {
                answer += "1";
                carry = 0;
            } else if (sum == 2) {
                answer += "0";
                carry = 1;
            } else {
                answer += "1";
                carry = 1;
            }
        }

        if (carry == 1) {
            answer += "1";
        }

        return new StringBuffer(answer).reverse().toString();
    }
}