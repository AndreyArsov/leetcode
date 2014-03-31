public class Solution {
    private HashMap<Integer, HashSet<Integer>> map;
    private int[] num;
    private boolean[] used;
    private ArrayList<Integer> current;
    private ArrayList<ArrayList<Integer>> answer;

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        map = new HashMap<Integer, HashSet<Integer>>();
        answer = new ArrayList<ArrayList<Integer>>();
        this.num = num;
        used = new boolean[num.length];
        current = new ArrayList<Integer>();

        search(0);
        return answer;
    }

    private void search(int p) {
        if (p == num.length) {
            ArrayList<Integer> newList = new ArrayList<Integer>();
            for (Integer i : current) {
                newList.add(i);
            }
            answer.add(newList);
            return;
        }

        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                HashSet<Integer> positions = map.get(num[i]);
                if (positions == null || !positions.contains(p)) {
                    used[i] = true;
                    if (positions == null) {
                        positions = new HashSet<Integer>();
                    }
                    positions.add(p);
                    map.put(num[i], positions);
                    current.add(num[i]);
                    search(p+1);
                    current.remove(current.size() - 1);
                    positions.remove(p);
                    map.put(num[i], positions);
                    used[i] = false;
                }
            }
        }
    }
}