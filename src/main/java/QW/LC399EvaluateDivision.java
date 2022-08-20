package QW;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC399EvaluateDivision {
    private class UF{
        int[] parent;
        double[] weight;
        public UF(int n){
            parent = new int[n];
            weight = new double[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                weight[i] = 1.0;
            }
        }
        public int find(int x){
            if(parent[x] != x){
                int p = parent[x];
                parent[x] = find(parent[x]);
                weight[x] = weight[x] * weight[p];
            }
            return parent[x];
        }
        public void union(int x, int y, double value){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return;
            }else{
                parent[rootX] = rootY;
                weight[rootX] = weight[y] * value / weight[x]; // weight[x] * weight[rootX] = value * weight[y]
            }
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        UF uf = new UF(2 * n);
        int id = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            List<String> l = equations.get(i);
            String num = l.get(0);
            String denom = l.get(1);
            if(!map.containsKey(num)){
                map.put(num, id++);
            }
            if(!map.containsKey(denom)){
                map.put(denom, id++);
            }
            uf.union(map.get(num), map.get(denom), values[i]);
        }

        int m = queries.size();
        double[] res = new double[m];
        // System.out.println(map);
        // System.out.println(Arrays.toString(uf.parent));
        for(int i = 0; i < m; i++){
            List<String> l = queries.get(i);
            String num = l.get(0);
            String denom = l.get(1);

            Integer id1 = map.get(num);
            Integer id2 = map.get(denom);
            if(id1 == null || id2 == null){
                res[i] = -1.0;
                continue;
            }
            int rootNum = uf.find(id1);
            int rootDenom = uf.find(id2);
            if(rootNum == rootDenom){
                res[i] = uf.weight[id1] / uf.weight[id2];
            }else{
                res[i] = -1.0;
            }
        }
        return res;
    }

}
// time O((m + n)*logn) space O(n)
