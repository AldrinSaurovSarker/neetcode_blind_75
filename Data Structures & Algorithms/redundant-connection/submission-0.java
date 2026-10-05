class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parents = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            int x = find(edge[0] - 1, parents);
            int y = find(edge[1] - 1, parents);

            if (x == y) {
                return edge;
            }

            union(x, y, parents, size);
        }
        return new int[]{-1, -1};
    }

    public int find(int x, int[] parents) {
        if (x != parents[x]) {
            parents[x] = find(parents[x], parents);
        }
        return parents[x];
    }

    public void union(int x, int y, int[] parents, int[] size) {
        if (size[x] < size[y]) {
            parents[x] = y;
            size[y] += size[x];
        } else {
            parents[y] = x;
            size[x] += size[y];
        }
    }
}