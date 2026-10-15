class Solution {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 1;

        Set<String> beginWordSet = new HashSet<>();
        Set<String> endWordSet = new HashSet<>();
        beginWordSet.add(beginWord);
        endWordSet.add(endWord);
        words.remove(beginWord);
        words.remove(endWord);
        int level = 1;

        while (!beginWordSet.isEmpty()) {
            if (beginWordSet.size() > endWordSet.size()) {
                Set<String> tempSet = beginWordSet;
                beginWordSet = endWordSet;
                endWordSet = tempSet;
            }

            Set<String> nextWordSet = new HashSet<>();

            for (String word : beginWordSet) {
                char[] charArray = word.toCharArray();

                for (int i = 0; i < charArray.length; i++) {
                    char oldChar = charArray[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == oldChar) continue;

                        charArray[i] = c;
                        String targetWord = new String(charArray);

                        if (endWordSet.contains(targetWord)) {
                            return level + 1;
                        }

                        if (words.remove(targetWord)) {
                            nextWordSet.add(targetWord);
                        }
                    }

                    charArray[i] = oldChar;
                }
            }
            beginWordSet = nextWordSet;
            level++;
        }
        return 0;
    }
}
