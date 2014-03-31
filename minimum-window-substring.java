public class Solution {
    private int[] target;

    private boolean satisfy(int[] window) {
        for (int i = 0; i < 256; i++) {
            if (window[i] < target[i]) {
                return false;
            }
        }

        return true;
    }

    public String minWindow(String S, String T) {
        if (S.length() == 0 || T.length() == 0) {
            return "";
        }

        target = new int[256];
        for (int i = 0; i < T.length(); i++) {
            target[(int)T.charAt(i)]++;
        }

        int[] current = new int[256];
        int head = 0;
        int tail = 0;
        int min = Integer.MAX_VALUE;
        int bestHead = 0;

        while (head <= tail && tail < S.length()) {
            current[(int)S.charAt(tail)]++;

            boolean moved = true;
            while (moved && satisfy(current)) {
                moved = false;
                int length = tail - head + 1;
                if (length < min) {
                    min = length;
                    bestHead = head;
                }

                if (head < tail) {
                    current[(int)S.charAt(head)]--;
                    head++;
                    moved = true;
                }

                for (; head < tail; head++) {
                    moved = true;
                    if (target[(int)S.charAt(head)] > 0) {
                        break;
                    }
                    current[(int)S.charAt(head)]--;
                }
            }

            tail++;
        }

        if (min != Integer.MAX_VALUE) {
            return S.substring(bestHead, bestHead + min);
        } else {
            return "";
        }
    }
}