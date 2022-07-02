package QW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC207CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : prerequisites) {
            List<Integer> cur = graph.getOrDefault(p[1], new ArrayList<>());
            cur.add(p[0]);
            graph.put(p[1], cur);
        }
        boolean[] visited = new boolean[numCourses]; // on current path
        boolean[] checked = new boolean[numCourses]; // mem
        // System.out.println(graph);
        for (int i : graph.keySet()) {
            if (hasCycle(i, graph, visited, checked)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasCycle(int curNum, Map<Integer, List<Integer>> graph, boolean[] visited, boolean[] checked) {
        if (visited[curNum]) {
            // System.out.println("curNum: " + curNum );
            return true;
        }
        if (checked[curNum]) {
            return false;
        }
        List<Integer> list = graph.get(curNum);
        if (list == null) return false;
        visited[curNum] = true;
        for (int j : list) {
            if (hasCycle(j, graph, visited, checked)) {
                return true;
            }
        }
        visited[curNum] = false;
        checked[curNum] = true;
        return false;
    }

    public static void main(String[] args) {
        int[][] prereq = new int[][]{{1,0},{0,1},{1,3},{2,3},{0,3},{2,4}};
        System.out.println(canFinish(5,prereq)); //false
        int[][] prereq2 = new int[][]{{1,0},{1,3},{2,3},{0,3},{2,4}};
        System.out.println(canFinish(5,prereq2)); //true
    }
}
// time O(E + V) space O(V + E)
