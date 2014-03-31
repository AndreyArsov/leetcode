public class Solution {
    private HashMap<Integer, Integer> map;

    public int firstMissingPositive(int[] A) {
        if (A.length == 0) {
            return 1;
        }

        int B[] = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            B[i + 1] = A[i];
        }
        B[0] = 0;
        A = B;

        map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }

        boolean[] visited = new boolean[A.length];
        int minNumber = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (!visited[i] && A[i] >= 0) {
                visited[i] = true;

                int next = A[i];
                while (map.containsKey(next)) {
                    visited[map.get(next)] = true;
                    next++;
                }

                if (next < minNumber) {
                    minNumber = next;
                }
            }
        }

        return minNumber;
    }
}