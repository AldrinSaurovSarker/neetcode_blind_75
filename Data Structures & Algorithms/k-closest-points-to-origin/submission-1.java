class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));

        for (int i = 0; i < points.length; i++) {
            double distance = euclideanDistance(points[i]);
            queue.offer(new double[]{i, distance});

            if (queue.size() > k) {
                queue.poll();
            }
        }
        
        int[][] ans = new int[k][2];
        int i = 0;
        while (!queue.isEmpty()) {
            int index = (int) queue.poll()[0];
            ans[i++] = points[index];
        }
        return ans;
    }

    public double euclideanDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
