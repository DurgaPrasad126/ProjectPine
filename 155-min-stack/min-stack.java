class MinStack {
    Stack<int[]> minStack;
    public MinStack() {
        minStack = new Stack<>();
    }
    
    public void push(int val) {
       if(minStack.isEmpty()){
        minStack.push(new int[]{val, val});
       }
       else {
        minStack.push(new int[]{val, minStack.peek()[1] > val ? val : minStack.peek()[1]});
       }
    }

    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek()[0];
    }
    
    public int getMin() {
        return minStack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */