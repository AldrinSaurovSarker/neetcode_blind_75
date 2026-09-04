class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> lookup = new HashMap<>();
        lookup.put('(', ')');
        lookup.put('{', '}');
        lookup.put('[', ']');

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    char l = stack.pop();
                    if (lookup.get(l) != c) return false;
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
