import java.math.BigInteger;

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int k = 0; k <= rowIndex; k++) {
            answer.add(C(rowIndex, k));
        }

        return answer;
    }

    private int C(int n, int k) {
        BigInteger a = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            a = a.multiply(new BigInteger(new Integer(i).toString()));
        }

        for (int i = 1; i <= k; i++) {
            a = a.divide(new BigInteger(new Integer(i).toString()));
        }

        for (int i = 1; i <= n - k; i++) {
            a = a.divide(new BigInteger(new Integer(i).toString()));
        }

        return a.intValue();
    }
}