public class Solution {
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            if (i1.start == i2.start) {
                return i1.end - i2.end;
            } else {
                return i1.start - i2.start;
            }
        }
    }

    private boolean tryMerge(ArrayList<Interval> intervals) {
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                Interval a = intervals.get(i);
                Interval b = intervals.get(j);
                if (b.start <= a.end) {
                    intervals.set(i, new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end)));
                    intervals.remove(j);
                    return true;
                }
            }
        }

        return false;
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals, new IntervalComparator());
        while (tryMerge(intervals)) { }
        return intervals;
    }
}