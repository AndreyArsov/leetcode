public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> w = new ArrayList<String>(Arrays.asList(words));
        ArrayList<String> lines = new ArrayList<String>();

        while (w.size() > 0) {
            int projectedLength = 0;
            int wordsTotalLength = 0;
            ArrayList<String> wordsForLine = new ArrayList<String>();
            while (w.size() > 0) {
                projectedLength += w.get(0).length() + 1;
                if (projectedLength - 1 > L) {
                    break;
                } else {
                    String word = w.remove(0);
                    wordsTotalLength += word.length();
                    wordsForLine.add(word);
                }
            }

            String line = "";
            if (wordsForLine.size() == 1) {
                line = wordsForLine.get(0);
                for (int i = 0; i < L - wordsTotalLength; i++) {
                    line += " ";
                }
            } else if (w.size() == 0) {
                for (String word : wordsForLine) {
                    line += word + " ";
                }
                for (int i = 0; i < L - wordsTotalLength - wordsForLine.size(); i++) {
                    line += " ";
                }
            } else {
                int[] spaceSizes = new int[wordsForLine.size() - 1];
                int remaingSpaceSize = L - wordsTotalLength;
                while (remaingSpaceSize > 0) {
                    for (int i = 0; i < wordsForLine.size() - 1; i++) {
                        spaceSizes[i]++;
                        remaingSpaceSize--;
                        if (remaingSpaceSize == 0) {
                            break;
                        }
                    }
                }

                for (int i = 0; i < wordsForLine.size() - 1; i++) {
                    line += wordsForLine.get(i);
                    for (int j = 0; j < spaceSizes[i]; j++) {
                        line += " ";
                    }
                }
                line += wordsForLine.get(wordsForLine.size() - 1);
            }

            lines.add(line);
        }

        return lines;
    }
}
