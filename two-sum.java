public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i]) && numbers[i] * 2 == target) {
                int prevPos = map.get(numbers[i]);
                return new int[] { prevPos + 1, i + 1 };
            }
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                int otherPos = map.get(target - numbers[i]);
                if (otherPos != i) {
                    return new int[] { Math.min(i, otherPos) + 1, Math.max(i, otherPos) + 1 };
                }
            }
        }

        return null;
    }
}