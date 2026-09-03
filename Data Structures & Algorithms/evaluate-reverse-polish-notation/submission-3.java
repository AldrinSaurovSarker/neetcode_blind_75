class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op1 + op2);
                }

                case "-" -> {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op2 - op1);
                }

                case "*" -> {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op1 * op2);
                }

                case "/" -> {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op2 / op1);
                }

                default -> stack.push(Integer.parseInt(token));
            }

            System.out.println(stack);
        }

        return stack.pop();
    }
}
