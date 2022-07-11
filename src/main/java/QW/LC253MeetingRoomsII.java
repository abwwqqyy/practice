package QW;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC253MeetingRoomsII {
    public static int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]);
        for(int i = 1; i < n; i++){
            int start = intervals[i][0];
            int end = minHeap.peek();
            if(start >= end){ // add to cur room, not increasing the num
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(intervals)); // 2
    }
}
// time O(nlogn) space O(n)
