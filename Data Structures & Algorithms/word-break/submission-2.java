class Solution {
    public record Word(String word, int start) {}

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean wordEnd = true;
        Set<Word> wordSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (wordEnd) {
                for (String word : wordDict) {
                    if (word.charAt(0) == s.charAt(i)) {
                        wordSet.add(new Word(word, i));
                    }
                }
            }
            wordEnd = false;
            Set<Word> tempSet = new HashSet<>(wordSet);

            for (Word record : tempSet) {
                String word = record.word();
                int index = record.start();

                if (word.charAt(i - index) != s.charAt(i)) {
                    wordSet.remove(record);
                } else if (i - index == word.length() - 1) {
                    wordEnd = true;
                    wordSet.remove(record);
                }
            }
        }
        return wordEnd;
    }
}
