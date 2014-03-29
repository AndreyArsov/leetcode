public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            map.put(num[i], i);
        }

        int maxLength = -1;
        boolean[] visited = new boolean[num.length];
        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                visited[i] = true;

                int number = num[i];
                int length = 0;
                while (map.containsKey(number)) {
                    length++;
                    visited[map.get(number)] = true;
                    number++;
                }

                number = num[i];
                while (map.containsKey(number)) {
                    length++;
                    visited[map.get(number)] = true;
                    number--;
                }

                length--;
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }

        return maxLength;
    }
}