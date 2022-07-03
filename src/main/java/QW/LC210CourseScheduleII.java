package QW;

import java.util.*;

public class LC210CourseScheduleII {
    private static boolean isPossible = true;
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if (numCourses == 1) return res;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] p : prerequisites){
            List<Integer> temp = graph.getOrDefault(p[1], new ArrayList<>());
            temp.add(p[0]);
            graph.put(p[1], temp);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] checked = new boolean[numCourses];
        List<Integer> order = new ArrayList<>();
        for(int i = 0; i < numCourses; i ++){
            if(!checked[i]){
                dfs(graph, i, order, visited, checked);
            }
        }
        // System.out.println(graph);
        // System.out.println(order);
        if(isPossible){
            for(int i = 0; i < numCourses; i ++){
                res[i] = order.get(numCourses - 1 - i);
            }
        }else{
            return new int[0];
        }
        return res;
    }
    private static void dfs(Map<Integer, List<Integer>> graph, int curNum, List<Integer> order, boolean[] visited, boolean[] checked){
        if(!isPossible){
            return;
        }
        if(checked[curNum]){
            return;
        }
        List<Integer> list = graph.get(curNum);//getOrDefault(curNum, new ArrayList<>());
        if(list == null) {
            checked[curNum] = true;
            order.add(curNum);
            return;
        }
        visited[curNum] = true;
        for(int i : list){
            if(visited[i]){
                isPossible = false;
            }else{
                dfs(graph, i, order, visited, checked);
            }
        }
        visited[curNum] = false;
        checked[curNum] = true;
        order.add(curNum);
    }

    public static void main(String[] args) {
        int[][] prereq2 = new int[][]{{1,0},{1,3},{2,3},{0,3},{2,4}};
        System.out.println(Arrays.toString(findOrder(5,prereq2))); //[4, 3, 2, 0, 1]
    }
}
// time O(V + E) space O(V+E)
