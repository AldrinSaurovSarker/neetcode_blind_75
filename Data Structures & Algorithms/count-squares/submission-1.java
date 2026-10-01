class CountSquares {
    record Point(int x, int y) {}

    Map<Point, Integer> pointMap;
    List<Point> pointList;

    public CountSquares() {
        pointMap = new HashMap<>();
        pointList = new ArrayList<>();
    }

    public void add(int[] point) {
        Point p = new Point(point[0], point[1]);
        pointMap.put(p, pointMap.getOrDefault(p, 0) + 1);
        pointList.add(p);
    }

    public int count(int[] point) {
        int count = 0;

        for (Point opposite : pointList) {
            int side1 = point[0] - opposite.x;
            int side2 = point[1] - opposite.y;

            if (side1 == 0) {
                continue;
            }

            if (side1 == side2) {
                Point adj1 = new Point(
                        Math.min(point[0], opposite.x),
                        Math.max(point[1], opposite.y)
                );

                Point adj2 = new Point(
                        Math.max(point[0], opposite.x),
                        Math.min(point[1], opposite.y)
                );

                count += pointMap.getOrDefault(adj1, 0) * pointMap.getOrDefault(adj2, 0);
            } else if (side1 + side2 == 0) {
                Point adj1 = new Point(
                        Math.min(point[0], opposite.x),
                        Math.min(point[1], opposite.y)
                );

                Point adj2 = new Point(
                        Math.max(point[0], opposite.x),
                        Math.max(point[1], opposite.y)
                );

                count += pointMap.getOrDefault(adj1, 0) * pointMap.getOrDefault(adj2, 0);
            }
        }
        return count;
    }
}
