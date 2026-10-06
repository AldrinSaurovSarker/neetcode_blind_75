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
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int ans = 0;

        for (Interval interval : intervals) {
            while (!queue.isEmpty() && queue.peek() <= interval.start) {
                queue.poll();
            }
            
            queue.offer(interval.end);
            ans = Math.max(ans, queue.size());
        }
        
        return ans;
    }
}
