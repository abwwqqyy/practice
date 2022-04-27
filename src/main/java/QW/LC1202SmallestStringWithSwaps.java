package QW;

import java.util.*;

class UnionFind1 {
    private int[] root;
    private int[] rank;

    // Initialize the array root and rank
    // Each vertex is representative of itself with rank 1
    public UnionFind1(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    // Get the root of a vertex
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        root[x] = find(root[x]);
        return root[x];
    }

    // Perform the union of two components
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] >= rank[rootY]) {
                root[rootY] = rootX;
                rank[rootX] += rank[rootY];
            } else {
                root[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }
        }
    }
}
public class LC1202SmallestStringWithSwaps {
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind1 uf = new UnionFind1(s.length());

        // Iterate over the edges
        for (List<Integer> edge : pairs) {
            int source = edge.get(0);
            int destination = edge.get(1);

            // Perform the union of end points
            uf.union(source, destination);
        }

        Map<Integer, List<Integer>> rootToComponent = new HashMap<>();
        // Group the vertices that are in the same component
        for (int vertex = 0; vertex < s.length(); vertex++) {
            int root = uf.find(vertex);
            // Add the vertices corresponding to the component root
            rootToComponent.putIfAbsent(root, new ArrayList<>());
            rootToComponent.get(root).add(vertex);
        }

        // String to store the answer
        char[] smallestString = new char[s.length()];
        // Iterate over each component
        for (List<Integer> indices : rootToComponent.values()) {
            // Sort the characters in the group
            List<Character> characters = new ArrayList<>();
            for (int index : indices) {
                characters.add(s.charAt(index));
            }
            Collections.sort(characters);

            // Store the sorted characters
            for (int index = 0; index < indices.size(); index++) {
                smallestString[indices.get(index)] = characters.get(index);
            }
        }

        return new String(smallestString);
    }

    public static void main(String[] args) {
        String s = "dcba";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(new Integer[]{0,3}));
        pairs.add(Arrays.asList(new Integer[]{1,2}));
        pairs.add(Arrays.asList(new Integer[]{0,2}));
        System.out.println(smallestStringWithSwaps(s, pairs)); // abcd
    }
}
