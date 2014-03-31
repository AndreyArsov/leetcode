public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        if (n == 0) {
            answer.add(0);
            return answer;
        }

        for (String s : search(n)) {
            answer.add(Integer.parseInt(s, 2));
        }

        return answer;
    }

    public ArrayList<String> search(int n) {
        if (n == 0) {
            ArrayList<String> list = new ArrayList<String>();
            list.add("");
            return list;
        }

        ArrayList<String> source = search(n - 1);
        ArrayList<String> generated = new ArrayList<String>();

        for (String s : source) {
            generated.add("0" + s);
        }

        for (int i = source.size() - 1; i >= 0; i--) {
            generated.add("1" + source.get(i));
        }

        return generated;
    }
}