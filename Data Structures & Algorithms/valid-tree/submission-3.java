class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        int[] parents = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            int x = find(edge[0], parents);
            int y = find(edge[1], parents);

            if (x == y) {
                return false;
            }

            union(x, y, parents, size);
        }

        int root = find(0, parents);

        for (int i = 1; i < n; i++) {
            if (root != find(i, parents)) {
                return false;
            }
        }

        return true;
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
