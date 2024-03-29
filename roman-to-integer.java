public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int answer = 0;
        int prev = 0;
        for (char c : s.toCharArray()) {
            int value = map.get(c);
            if (prev == 0) {
                prev = value;
                continue;
            }

            if (value > prev) {
                answer += value - prev;
                prev = 0;
            } else {
                answer += prev;
                prev = value;
            }
        }

        answer += prev;

        return answer;
    }
}