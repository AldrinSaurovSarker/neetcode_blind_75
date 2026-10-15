class Solution {
    public static int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String operation : operations) {
            switch (operation) {
                case "+" -> {
                    if (stack.size() > 1) {
                        int first = stack.pop();
                        int second = stack.pop();
                        stack.push(second);
                        stack.push(first);
                        stack.push(first + second);
                    }
                }

                case "D" -> {
                    if (!stack.isEmpty()) {
                        int prev = stack.peek();
                        stack.push(prev * 2);
                    }
                }

                case "C" -> {
                    if (!stack.isEmpty()) stack.pop();
                }

                default -> {
                    int value = Integer.parseInt(operation);
                    stack.push(value);
                }
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}