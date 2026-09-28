class TrieNode {
    TrieNode[] children;
    boolean hasWordEnded;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.hasWordEnded = false;
    }
}

class WordDictionary {
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.hasWordEnded = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.hasWordEnded;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && search(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }

        if (node.children[c - 'a'] == null) {
            return false;
        }
        
        return search(word, index + 1, node.children[c - 'a']);
    }
}
