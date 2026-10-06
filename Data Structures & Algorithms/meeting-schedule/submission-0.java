/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        PriorityQueue<Interval> queue = new PriorityQueue<>((a, b) -> a.start - b.start);

        for (Interval interval : intervals) {
            queue.offer(interval);
        }

        int end = 0;

        while (!queue.isEmpty()) {
            Interval interval = queue.poll();

            if (interval.start < end) {
                return false;
            }

            end = interval.end;
        }
        return true;
    }
}
