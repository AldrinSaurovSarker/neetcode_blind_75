class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int max = 0;
        for (int[] interval : intervals) {
            max = Math.max(max, interval[0]);
        }
        max = Math.max(max, newInterval[0]);

        int[] arr = new int[max + 1];
        Arrays.fill(arr, -1);
        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            arr[start] = Math.max(arr[start], end);
        }

        arr[newInterval[0]] = Math.max(arr[newInterval[0]], newInterval[1]);

        int currStart = -1;
        int currEnd = -1;
        int total = 0;
        int[][] results = new int[intervals.length + 1][2];

        for (int i = 0; i <= max; i++) {
            if (arr[i] != -1) {
                if (currStart == -1) currStart = i;

                currEnd = Math.max(currEnd, arr[i]);
            }

            if (currEnd == i) {
                results[total++] = new int[]{currStart, currEnd};
                currStart = -1;
                currEnd = -1;
            }
        }

        if (currStart != -1) {
            results[total++] = new int[]{currStart, currEnd};
        }
        
        return Arrays.copyOf(results, total);
    }
}
