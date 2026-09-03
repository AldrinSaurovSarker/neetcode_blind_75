class MinStack {
    private ArrayList<Integer> stack;
    private ArrayList<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.minStack = new ArrayList<>();
    }
    
    public void push(int val) {
        this.stack.add(val);
        this.minStack.add(Math.min(val, this.getMin()));
    }
    
    public void pop() {
        this.stack.remove(this.stack.size() - 1);
        this.minStack.remove(this.minStack.size() - 1);
    }
    
    public int top() {
        return this.stack.get(this.stack.size() - 1);
    }
    
    public int getMin() {
        if (this.minStack.isEmpty()) return Integer.MAX_VALUE;

        return this.minStack.get(this.minStack.size() - 1);
    }
}
