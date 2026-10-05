class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int components = n;

        for (int[] edge : edges) {
            int parent1 = find(edge[0], parent);
            int parent2 = find(edge[1], parent);

            if (parent1 != parent2) {
                union(parent1, parent2, parent);
                components--;
            }
        }
        return components;
    }

    public int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x], parent);
    }

    public void union(int x, int y, int[] parent) {
        parent[find(x, parent)] = y;
    }
}
