public class Solution {
    private int[] num;

    private class Pair {
        public int v1;
        public int v2;
        Pair(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        public boolean canJoin(Pair q) {
            return v1 != q.v1 && v1 != q.v2 && v2 != q.v1 && v2 != q.v2;
        }

    }

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<Integer, ArrayList<Pair>>();
        this.num = num;

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                ArrayList<Pair> list = map.get(num[i] + num[j]);
                if (list == null) {
                    list = new ArrayList<Pair>();
                }
                list.add(new Pair(i, j));
                map.put(num[i] + num[j], list);
            }
        }

        Set<Integer> keys = map.keySet();
        HashSet<String> answers = new HashSet<String>();
        for (Integer sum : keys) {
            if (map.containsKey(target - sum)) {
                ArrayList<Pair> l1 = map.get(sum);
                ArrayList<Pair> l2 = map.get(target - sum);
                for (Pair p1 : l1) {
                    for (Pair p2 : l2) {
                        if (p1.canJoin(p2)) {
                            ArrayList<Integer> nums = new ArrayList<Integer>();
                            nums.add(num[p1.v1]);
                            nums.add(num[p1.v2]);
                            nums.add(num[p2.v1]);
                            nums.add(num[p2.v2]);
                            Collections.sort(nums);
                            String s = nums.get(0).toString() + nums.get(1).toString() + nums.get(2).toString() + nums.get(3).toString();
                            if (!answers.contains(s)) {
                                answers.add(s);
                                ArrayList<Integer> list = new ArrayList<Integer>();
                                list.add(nums.get(0));
                                list.add(nums.get(1));
                                list.add(nums.get(2));
                                list.add(nums.get(3));
                                answer.add(list);
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}