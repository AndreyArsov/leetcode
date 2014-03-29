public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < numRows; i++) {
            ArrayList thisRow = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    thisRow.add(1);
                } else {
                    ArrayList<Integer> aboveRow = result.get(i - 1);
                    thisRow.add(aboveRow.get(j) + aboveRow.get(j - 1));
                }
            }
            result.add(thisRow);
        }

        return result;
    }
}