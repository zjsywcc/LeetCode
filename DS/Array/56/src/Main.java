import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>();
//        intervals.add(new Interval(1, 3));
//        intervals.add(new Interval(2, 6));
//        intervals.add(new Interval(8, 10));
//        intervals.add(new Interval(15, 18));
//        printIntervals(merge(intervals));
//        intervals.add(new Interval(1, 4));
//        intervals.add(new Interval(2, 3));
//        printIntervals(merge(intervals));
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(0, 2));
        intervals.add(new Interval(3, 5));
        printIntervals(merge(intervals));
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        printIntervals(intervals);
        int lastStart = intervals.get(0).start;
        int lastEnd = intervals.get(0).end;
        List<Interval> rst = new ArrayList<Interval>();
        boolean flag = true;
        for(Interval interval : intervals) {
            if(interval.end <= lastEnd) {
                if (flag) {
                    rst.add(interval);
                    flag = false;
                }
            } else {
                if(interval.start <= lastEnd) {
                    rst.remove(rst.size() - 1);
                    rst.add(new Interval(lastStart, interval.end));
                } else {
                    rst.add(interval);
                }
            }
            lastStart = rst.get(rst.size() - 1).start;
            lastEnd = rst.get(rst.size() - 1).end;
        }
        return rst;
    }

    public static void printIntervals(List<Interval> intervals) {
        for(Interval interval : intervals) {
            System.out.print(String.format("[%s, %s],", interval.start, interval.end));
        }
        System.out.println();
    }
}
