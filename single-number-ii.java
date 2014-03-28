public class Solution {
    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashSet<Integer> missingNumbers = new HashSet<Integer>();

        for (int i = 0; i < A.length; i++) {
            int val = A[i];
            if (!map.containsKey(val)) {
                map.put(val, 1);
                missingNumbers.add(val);
            } else {
                int current = map.get(val);
                map.put(val, current + 1);
                if (current == 2) {
                    missingNumbers.remove(val);
                }
            }
        }

        Integer[] a = missingNumbers.toArray(new Integer[0]);
        return a[0];
    }
}