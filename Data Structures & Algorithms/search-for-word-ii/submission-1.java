class TrieNode {
    TrieNode[] children;
    boolean hasWordEnded;

    public TrieNode() {
        children = new TrieNode[26];
        hasWordEnded = false;
    }
}

class Solution {
    TrieNode root = new TrieNode();
    Set<String> ans = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, new StringBuilder());
            }
        }

        return new ArrayList<>(ans);
    }

    public void dfs(char[][] board, int x, int y, TrieNode node, StringBuilder sb) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return;
        }

        if (board[x][y] == '#') {
            return;
        }

        char c = board[x][y];
        int index = c - 'a';

        if (node.children[index] == null) {
            return;
        }

        node = node.children[index];

        sb.append(c);

        if (node.hasWordEnded) {
            ans.add(sb.toString());
        }

        board[x][y] = '#';

        dfs(board, x, y - 1, node, sb);
        dfs(board, x, y + 1, node, sb);
        dfs(board, x - 1, y, node, sb);
        dfs(board, x + 1, y, node, sb);

        board[x][y] = c;
        sb.deleteCharAt(sb.length() - 1);
    }

    public void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.hasWordEnded = true;
    }

    public boolean search(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.hasWordEnded;
    }

    public boolean isPrefix(String prefix) {
        TrieNode node = root;

        for (char c : prefix.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                return false;
            }

            node = node.children[index];
        }
        return true;
    }
}
