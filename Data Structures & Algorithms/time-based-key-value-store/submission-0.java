class TimeMap {
    Map<String, List<Integer>> keyMap;
    Map<String, List<String>> valueMap;

    public TimeMap() {
        keyMap = new HashMap<>();
        valueMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyMap.computeIfAbsent(key, k -> new ArrayList<>()).add(timestamp);
        valueMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }
    
    public String get(String key, int timestamp) {
        List<Integer> keys = keyMap.getOrDefault(key, new ArrayList<>());
        List<String> values = valueMap.getOrDefault(key, new ArrayList<>());

        if (keys.isEmpty() || keys.get(0) > timestamp) {
            return "";
        }

        int low = 0;
        int high = keys.size() - 1;
        String ans = "";

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (keys.get(mid) == timestamp) {
                return values.get(mid);
            } else if (keys.get(mid) > timestamp) {
                high = mid - 1;
            } else {
                ans = values.get(mid);
                low = mid + 1;
            }
        }
        return ans;
    }
}
