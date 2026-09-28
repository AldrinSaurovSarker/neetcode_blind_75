class TrieNode {
    TrieNode[] children;
    boolean hasWordEnded;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.hasWordEnded = false;
    }
}

class PrefixTree {
    TrieNode root;

    public PrefixTree() {
         this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.hasWordEnded = true;
    }

    public boolean search(String word) {
        TrieNode node = root;   

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.hasWordEnded;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;   

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }
}
