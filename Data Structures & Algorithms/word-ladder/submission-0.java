class Solution {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) return 0;

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        words.remove(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (Objects.equals(word, endWord)) {
                    return level;
                }

                for (int j = 0; j < beginWord.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word.charAt(j)) continue;

                        String targetWord = word.substring(0, j) + c + word.substring(j + 1);

                        if (words.contains(targetWord)) {
                            words.remove(targetWord);
                            queue.offer(targetWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}

