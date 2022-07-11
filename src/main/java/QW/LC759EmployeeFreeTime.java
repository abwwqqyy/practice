package QW;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
public class LC759EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        int n = schedule.size();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> schedule.get(a[0]).get(a[1]).start - schedule.get(b[0]).get(b[1]).start); //sort by first starting of each employee
        for(int i = 0; i < n; i++){
            pq.offer(new int[]{i, 0});
        }
        List<Interval> res = new ArrayList<>();
        int prev = schedule.get(pq.peek()[0]).get(pq.peek()[1]).end; // last end time
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            Interval curInterval = schedule.get(cur[0]).get(cur[1]);
            if(curInterval.start > prev){
                res.add(new Interval(prev, curInterval.start));
            }
            prev = Math.max(prev, curInterval.end);
            if(schedule.get(cur[0]).size() > cur[1] + 1){ // more intervals for this employee
                pq.offer(new int[]{cur[0], cur[1] + 1});
            }
        }
        return res;
    }
}
// time O(nlogk) space O(k),  k for num of employees
