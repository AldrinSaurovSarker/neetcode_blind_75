class Solution {
    public int[][] merge(int[][] intervals) {
        int max = 0;
        for (int[] interval : intervals) {
            max = Math.max(interval[0], max);
        }

        int[] arr = new int[max + 1];
        Arrays.fill(arr, -1);

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            arr[start] = Math.max(arr[start], end);
        }

        int currStart = -1;
        int currEnd = -1;
        List<int[]> results = new ArrayList<>();

        for (int i = 0; i <= max; i++) {
            if (arr[i] != -1) {
                currEnd = Math.max(currEnd, arr[i]);

                if (currStart == -1) currStart = i;
            }

            if (currEnd == i) {
                results.add(new int[]{currStart, currEnd});
                currStart = -1;
                currEnd = -1;
            }
        }

        if (currStart != -1)
            results.add(new int[]{currStart, currEnd});
    
        return results.toArray(new int[results.size()][]);
    }
}
