public class Solution {
    private String convert(int count, String ones, String fives, String tens) {
        String answer = "";
        if (count <= 3) {
            for (int i = 0; i < count; i++) {
                answer += ones;
            }
        } else if (count == 4) {
            answer += ones + fives;
        } else if (count < 9) {
            answer += fives;
            for (int i = 0; i < count - 5; i++) {
                answer += ones;
            }
        } else {
            answer += ones + tens;
        }

        return answer;
    }

    public String intToRoman(int num) {
        String answer = "";

        int thousands = num / 1000;
        answer += convert(thousands, "M", "IMPOSSIBLE", "IMPOSSIBLE");
        num -= thousands * 1000;

        int hundreds = num / 100;
        answer += convert(hundreds, "C", "D", "M");
        num -= hundreds * 100;

        int tens = num / 10;
        answer += convert(tens, "X", "L", "C");
        num -= tens * 10;

        answer += convert(num, "I", "V", "X");

        return answer;
    }
}