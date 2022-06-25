package QW;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC630CourseScheduleIII {
    public static int scheduleCourse(int[][] courses) {
        int n = courses.length;
        int curTime = 0;
        Arrays.sort(courses, (a, b)->a[1] - b[1]);
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < n; i++){
            int[] cur = courses[i];
            if(curTime + cur[0] <= cur[1]){
                heap.offer(cur[0]);
                curTime += cur[0];
            }else{
                if(!heap.isEmpty() && heap.peek() > cur[0]){
                    curTime += cur[0] - heap.poll();
                    heap.offer(cur[0]);
                }
            }
        }
        return heap.size();
    }

    public static void main(String[] args) {
        int[][] courses = new int[][]{{5,5},{4,6},{2,6}};
        System.out.println(scheduleCourse(courses)); // 2
    }
}
// time O(nlogn) space O(n)
