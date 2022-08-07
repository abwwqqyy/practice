package QW;

//
class LC261GraphValidTree {
    public static boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }
        UF unionFind = new UF(n);
        for(int[] e : edges){
            int a = e[0];
            int b = e[1];
            if(!unionFind.union(a,b)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{0,2},{0,3},{1,4}};
        System.out.println(validTree(5,edges));// true
        int[][] edges2 = new int[][]{{0,1},{0,2},{0,3},{1,4},{2,3}};
        System.out.println(validTree(5,edges2));// false
    }
}
// time O(n) space O(n)

