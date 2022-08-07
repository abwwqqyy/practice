package QW;

import java.util.ArrayList;
import java.util.List;

class UF{
    private int[] parent;
    private int[] size;
    public UF(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = -1;
            size[i] = 1;
        }
    }
    public void setParent(int i){
        parent[i] = i;
    }
    public boolean isLand(int i){
        return parent[i] >= 0;
    }
    public int find(int a){
        int root = a;
        while(parent[root] != root){
            root = parent[root];
        }
        while(parent[a] != a){
            int temp = parent[a];
            parent[a] = root;
            a = temp;
        }
        return root;
    }
    public boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB){
            return false;
        }
        if(size[a] > size[b]){
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }else{
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
        return true;
    }
}

class LC305NumberOfIslandsII {
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        UF uf = new UF(m * n);
        int count = 0;
        List<Integer> res = new ArrayList<>();
        for(int[] pos : positions){
            int r = pos[0];
            int c = pos[1];
            int index = r * n + c;
            if(uf.isLand(index)){
                res.add(count);
                continue;
            }
            uf.setParent(index);
            count++;
            if (r - 1 >= 0 && uf.isLand((r-1) * n + c)){
                if(uf.union(index, (r-1) * n + c)){
                    count--;
                }
            }
            if (r + 1 < m && uf.isLand((r+1) * n + c)){
                if(uf.union(index, (r+1) * n + c)){
                    count--;
                }
            }
            if (c - 1 >= 0 && uf.isLand(r * n + c - 1)){
                if(uf.union(index, r * n + c - 1)){
                    count--;
                }
            }
            if (c + 1 < n && uf.isLand(r * n + c + 1)){
                if(uf.union(index, r * n + c + 1)){
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] positions = new int[][]{{0,0},{0,1},{1,2},{2,1}};
        System.out.println(numIslands2(3,3,positions)); // [1,1,2,3]
    }
}
// time O(L + mn) space O(mn)

