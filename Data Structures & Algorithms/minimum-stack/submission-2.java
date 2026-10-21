class MinStack {
    
    Stack<Integer> orderStack;
    Stack<Integer> minValStack;

    public MinStack() {
        this.orderStack = new Stack();
        this.minValStack = new Stack();
    }
    
    public void push(int val) {
        orderStack.push(val);
        int minVal = minValStack.isEmpty()? val : Math.min(val, minValStack.peek());
        minValStack.push(minVal);
    }
    
    public void pop() {
        orderStack.pop();
        minValStack.pop();
    }
    
    public int top() {
        return orderStack.peek();
    }
    
    public int getMin() {
        return minValStack.peek();
    }
}
