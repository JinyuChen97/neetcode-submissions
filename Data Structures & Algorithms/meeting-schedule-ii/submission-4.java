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
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->Integer.compare(a.end,b.end));
        
        intervals.sort((a,b)->Integer.compare(a.start,b.start));

        for(int i=0;i<intervals.size();i++){
            if(!pq.isEmpty()&&intervals.get(i).start>=pq.peek().end){
                pq.poll();
            }
            pq.offer(intervals.get(i));
        }
        return pq.size();
    }
}
