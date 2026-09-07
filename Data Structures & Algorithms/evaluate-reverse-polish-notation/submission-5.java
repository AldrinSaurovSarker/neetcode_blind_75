class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }

            int x = stack.pop();
            int y = stack.pop();

            int ans = switch (token) {
                case "+" -> y + x;
                case "-" -> y - x;
                case "*" -> y * x;
                case "/" -> y / x;
                default -> 0;
            };

            stack.push(ans);
        }
        return stack.pop();
    }
}
