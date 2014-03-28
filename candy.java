public class Solution {
    public int candy(int[] ratings) {
        int[] count = new int[ratings.length];

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i] && count[i - 1] >= count[i]) {
                count[i] = count[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i] && count[i + 1] >= count[i]) {
                count[i] = count[i + 1] + 1;
            }
        }

        int sum = ratings.length;
        for (int i = 0; i < ratings.length; i++) {
            sum += count[i];
        }

        return sum;
    }
}