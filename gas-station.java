public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        boolean[] tried = new boolean[n];

        for (int start = 0; start < n; start++) {
            if (tried[start]) {
                return -1;
            }

            tried[start] = true;
            int current = start;
            int fuel = 0;
            while (true) {
                fuel += gas[current] - cost[current];
                if (fuel < 0) {
                    start = current;
                    break;
                }
                current = (current + 1) % n;
                if (current == start) {
                    return start;
                }
            }
        }

        return -1;
    }
}