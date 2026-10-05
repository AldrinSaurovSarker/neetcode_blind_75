class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parents = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            int x = find(edge[0], parents);
            int y = find(edge[1], parents);

            if (x == y) {
                return false;
            }

            union(x, y, parents, rank);
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

    public void union(int x, int y, int[] parents, int[] rank) {
        if (rank[x] < rank[y]) {
            parents[x] = y;
            rank[y] += rank[x];
        } else {
            parents[y] = x;
            rank[x] += rank[y];
        }
    }
}
