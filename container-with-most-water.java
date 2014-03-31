public class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = -1;
        while (i != j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > max) {
                max = area;
            }

            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return max;
    }
}