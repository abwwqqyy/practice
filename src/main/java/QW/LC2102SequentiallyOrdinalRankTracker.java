package QW;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC2102SequentiallyOrdinalRankTracker {
    private Queue<Pair<String, Integer>> maxHeap;
    private Queue<Pair<String, Integer>> minHeap;

    public LC2102SequentiallyOrdinalRankTracker() { // integer equals
        maxHeap = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        minHeap = new PriorityQueue<>((a,b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
    }

    public void add(String name, int score) {
        Pair<String, Integer> cur = new Pair(name, score);
        minHeap.offer(cur);
        maxHeap.offer(minHeap.poll());
        // System.out.println(maxHeap);
    }

    public String get() {
        Pair<String, Integer> cur = maxHeap.poll();
        minHeap.offer(cur);
        // System.out.println(minHeap);
        return minHeap.peek().getKey();
    }
}
// time O(nlogn) space O(n)
