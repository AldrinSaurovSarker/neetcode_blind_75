class MinStack {
    List<Integer> stack;
    int min;

    public MinStack() {
        stack = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.add(val);
        min = Math.min(min, val);
    }
    
    public void pop() {
        int top = top();

        if (top == min) {
            min = Integer.MAX_VALUE;
            for (int i=0; i<stack.size() - 1; i++) {
                min = Math.min(min, stack.get(i));
            }
        }

        stack.remove(stack.size() - 1);
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return min;
    }
}
