public class Solution {
    public String convert(String s, int nRows) {
        String[] rows = new String[nRows];
        for (int k = 0; k < nRows; k++) {
            rows[k] = "";
        }

        int i = 0;
        int j = 0;
        boolean down = true;
        while (s.length() > 0) {
            rows[i] += Character.toString(s.charAt(0));
            if (down && i == nRows - 1) {
                down = false;
            } else if (!down && i == 0) {
                down = true;
            }
            if (down && i < nRows - 1) {
                i++;
            } else if (!down && i > 0){
                i--;
                j++;
            }
            s = s.substring(1);
        }

        String answer = "";
        for (String ss : rows) {
            answer += ss;
        }

        return answer;
    }
}
