public class Solution {
    public String getPermutation(int n, int k) {
        k--;
        HashSet<Integer> remaining = new HashSet<Integer>();
        for (int i = 1; i <= n; i++) {
            remaining.add(i);
        }

        String answer = "";

        for (int l = n - 1; l >= 0; l--) {
            int factorial = 1;
            for (int i = 1; i <= l; i++) {
                factorial *= i;
            }

            ArrayList<Integer> digits = new ArrayList<Integer>();
            for (Integer i : remaining) {
                digits.add(i);
            }
            Collections.sort(digits);

            int digit = digits.get(k / factorial);
            answer = answer + Integer.toString(digit);
            k = k % factorial;
            remaining.remove(digit);
        }

        return answer;
    }
}