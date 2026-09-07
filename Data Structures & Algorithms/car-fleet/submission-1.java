class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // int[] = {position, speed}
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i=0; i<position.length; i++) {
            queue.offer(new int[]{position[i], speed[i]});
        }

        int fleet = 0;
        double previousTime = 0;

        while (!queue.isEmpty()) {
            int[] car = queue.poll();
            double currentTime = (double) (target - car[0]) / car[1];

            if (currentTime > previousTime) {
                fleet++;
                previousTime = currentTime;
            }
        }
        return fleet;
    }
}
