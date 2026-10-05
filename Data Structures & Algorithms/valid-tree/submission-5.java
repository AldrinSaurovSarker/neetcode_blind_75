class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int[] edge : edges) {
            int x = find(edge[0], parent);
            int y = find(edge[1], parent);

            if (x == y) {
                return false;
            }

            if (parent[x] > parent[y]) {
                int temp = x;
                x = y;
                y = temp;
            }

            parent[x] += parent[y];
            parent[y] = x;
        }

        return true;
    }

    private int find(int x, int[] parent) {
        if (parent[x] < 0) {
            return x;
        }

        return parent[x] = find(parent[x], parent);
    }
}