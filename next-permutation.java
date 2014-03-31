public class Solution {
    public void nextPermutation(int[] num) {
        boolean found = false;
        int i = 0;
        for (i = num.length - 2; i >= 0 ; i--) {
            if (num[i] < num[i + 1]) {
                found = true;
                break;
            }
        }

        if (!found) {
            for (int z = 0; z < num.length / 2; z++) {
                int t = num[z];
                num[z] = num[num.length - z - 1];
                num[num.length - z - 1] = t;
            }
            return;
        }

        int j = 0;
        for (j = num.length - 1; j > i; j--) {
            if (num[j] > num[i]) {
                break;
            }
        }

        int t = num[j];
        num[j] = num[i];
        num[i] = t;

        for (int k = i + 1; k <= (num.length + i) / 2; k++) {
            t = num[k];
            num[k] = num[num.length + i - k];
            num[num.length + i - k] = t;
        }
    }
}