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
                // start DFS here
                dfs(board, i, j, new StringBuilder());
            }
        }

        return new ArrayList<>(ans);
    }

    public void dfs(char[][] board, int x, int y, StringBuilder sb) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return;
        }

        if (board[x][y] == '#') {
            return;
        }

        sb.append(board[x][y]);
        char temp = board[x][y];
        board[x][y] = '#';

        String current = sb.toString();

        if (!isPrefix(current)) {
            board[x][y] = temp;
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        if (search(current)) {
            ans.add(current);
        }

        dfs(board, x, y - 1, sb);
        dfs(board, x, y + 1, sb);
        dfs(board, x - 1, y, sb);
        dfs(board, x + 1, y, sb);

        board[x][y] = temp;
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
